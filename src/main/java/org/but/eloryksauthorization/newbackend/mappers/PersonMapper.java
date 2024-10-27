package org.but.eloryksauthorization.newbackend.mappers;
import org.but.eloryksauthorization.newbackend.api.PersonCreateDTO;
import org.but.eloryksauthorization.newbackend.api.PersonDTO;
import org.but.eloryksauthorization.newbackend.api.PersonUpdateDTO;
import org.but.eloryksauthorization.newbackend.data.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring", uses = PersonRoleMapper.class)
public interface PersonMapper {

    PersonUpdateDTO personToPersonUpdateDTO(Person person);

    Person personDTOToUpdatePerson(PersonUpdateDTO personDTO);

    @Mapping(target = "pwd", ignore = true)
    void updateEntityFromUpdateDTO(PersonUpdateDTO dto, @MappingTarget Person entity);

    List<PersonUpdateDTO> toDTOUpdateList(List<Person> entities);

    List<Person> toEntityUpdateList(List<PersonUpdateDTO> dtos);

    PersonCreateDTO personToPersonCreateDTO(Person person);

    @Mapping(target = "idPerson", ignore = true)
    @Mapping(target = "pwd", ignore = true)
    Person personDTOToCreatePerson(PersonCreateDTO personDTO);

    void updateEntityFromCreateDTO(PersonCreateDTO dto, @MappingTarget Person entity);

    List<PersonCreateDTO> toDTOCreateList(List<Person> entities);

    List<Person> toEntityCreateList(List<PersonCreateDTO> dtos);

    @Mapping(source = "idPerson", target = "idPerson")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "givenName", target = "givenName")
    @Mapping(source = "familyName", target = "familyName")
    @Mapping(source = "nickname", target = "nickname")
    @Mapping(source = "pwd", target = "pwd")
    @Mapping(source = "personRoles", target = "personRoles")
    PersonDTO personToPersonDTO(Person person);

    Person personDTOToPerson(PersonDTO personDTO);

    void updateEntityFromDTO(PersonDTO dto, @MappingTarget Person entity);

    List<PersonDTO> toDTOList(List<Person> entities);

    List<Person> toEntityList(List<PersonDTO> dtos);
}
