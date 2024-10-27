package org.but.eloryksauthorization.newbackend.service;
import jakarta.transaction.Transactional;
import org.but.eloryksauthorization.newbackend.api.PersonCreateDTO;
import org.but.eloryksauthorization.newbackend.api.PersonDTO;
import org.but.eloryksauthorization.newbackend.api.PersonRoleDTO;
import org.but.eloryksauthorization.newbackend.api.PersonUpdateDTO;
import org.but.eloryksauthorization.newbackend.data.entity.Person;
import org.but.eloryksauthorization.newbackend.data.entity.PersonRole;
import org.but.eloryksauthorization.newbackend.data.entity.Role;
import org.but.eloryksauthorization.newbackend.data.repository.PersonRepository;
import org.but.eloryksauthorization.newbackend.data.repository.PersonRoleRepository;
import org.but.eloryksauthorization.newbackend.data.repository.RoleRepository;
import org.but.eloryksauthorization.newbackend.exceptions.EmailAlreadyInUseException;
import org.but.eloryksauthorization.newbackend.exceptions.UserExistsException;
import org.but.eloryksauthorization.newbackend.exceptions.VehicleNotFoundException;
import org.but.eloryksauthorization.newbackend.mappers.PersonMapper;
import org.but.eloryksauthorization.newbackend.mappers.PersonRoleMapper;
import org.but.eloryksauthorization.newbackend.mappers.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final RoleRepository roleRepository;

    private final PersonRoleRepository personRoleRepository;

    private final PersonMapper personMapper;

    private final RoleMapper roleMapper;

    private final PersonRoleMapper personRoleMapper;

    private final Argon2PasswordEncoder passwordEncoder;


    @Autowired
    public PersonService(
            PersonRepository personRepository,
            RoleRepository roleRepository,
            PersonRoleRepository personRoleRepository,
            PersonMapper personMapper,
            RoleMapper roleMapper,
            PersonRoleMapper personRoleMapper,
            Argon2PasswordEncoder passwordEncoder
    ) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.personRoleRepository = personRoleRepository;
        this.personMapper = personMapper;
        this.roleMapper = roleMapper;
        this.personRoleMapper = personRoleMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public List<PersonDTO> findAll() {
        List<Person> persons = personRepository.findAll();
        return personMapper.toDTOList(persons);
    }

    @Transactional
    public PersonCreateDTO save(PersonCreateDTO personDTO) {
        boolean exists = personRepository.existsByEmail(personDTO.getEmail());
        if (exists) {
            throw new UserExistsException("User already exists with given ID or email");
        }
        Person person = personMapper.personDTOToCreatePerson(personDTO);
        person.setPwd(passwordEncoder.encode(personDTO.getPwd()));
        Set<PersonRole> personRoles = new HashSet<>();
        for (PersonRoleDTO prDto : personDTO.getPersonRoles()) {
            Role role = roleRepository.findById(prDto.getIdRole())
                    .orElseThrow(() -> new RuntimeException("Role not found with id " + prDto.getIdRole()));

            PersonRole personRole = new PersonRole();
            personRole.setPerson(person);
            personRole.setRole(role);
            personRole.setStartedAt(prDto.getStartedAt());
            personRole.setEndedAt(prDto.getEndedAt());
            personRole.setExpirationDate(prDto.getExpirationDate());
            personRoles.add(personRole);
        }

        person.setPersonRoles(personRoles);
        person = personRepository.save(person);
        return personMapper.personToPersonCreateDTO(person);
    }

    @Transactional
    public PersonUpdateDTO update(PersonUpdateDTO personDTO) {
        Person person = personRepository.findById(personDTO.getIdPerson())
                .orElseThrow(() -> new RuntimeException("Person not found with id " + personDTO.getIdPerson()));

        if (!person.getEmail().equals(personDTO.getEmail())) {
            personRepository.findByEmailAndIdPersonNot(personDTO.getEmail(), personDTO.getIdPerson())
                    .ifPresent(p -> {
                        throw new EmailAlreadyInUseException("Email already in use by another user");
                    });
        }
        personMapper.updateEntityFromUpdateDTO(personDTO, person);
        updatePersonRoles(person, personDTO.getPersonRoles());
        personRepository.save(person);
        return personMapper.personToPersonUpdateDTO(person);
    }

    private void updatePersonRoles(Person person, Set<PersonRoleDTO> newRoles) {
        Set<PersonRole> currentRoles = person.getPersonRoles();

        Map<Long, PersonRole> currentRolesMap = currentRoles.stream()
                .filter(role -> role.getRole() != null)
                .collect(Collectors.toMap(role -> role.getRole().getIdRole(), role -> role));

        Set<Long> newRoleIds = newRoles.stream()
                .map(PersonRoleDTO::getIdRole)
                .collect(Collectors.toSet());

        currentRoles.removeIf(role -> role.getRole() == null || !newRoleIds.contains(role.getRole().getIdRole()));

        for (PersonRoleDTO roleDTO : newRoles) {
            if (roleDTO == null || roleDTO.getIdRole() == null) {
                continue;
            }
            PersonRole personRole = currentRolesMap.get(roleDTO.getIdRole());
            if (personRole == null) {
                Role role = roleRepository.findById(roleDTO.getIdRole())
                        .orElseThrow(() -> new IllegalStateException("Role not found with id: " + roleDTO.getIdRole()));
                personRole = new PersonRole(person, role, roleDTO.getStartedAt(), roleDTO.getEndedAt(), roleDTO.getExpirationDate());
                person.getPersonRoles().add(personRole);
            } else {
                personRole.setStartedAt(roleDTO.getStartedAt());
                personRole.setEndedAt(roleDTO.getEndedAt());
                personRole.setExpirationDate(roleDTO.getExpirationDate());
            }
        }
    }

    @Transactional
    public void deleteById(List<Long> userIds) {

        for (Long userId : userIds){
            Person person = personRepository.findById(userId)
                            .orElseThrow(() -> new VehicleNotFoundException("User with ID " + userId + " not found"));
            personRepository.delete(person);
        }
    }
}
