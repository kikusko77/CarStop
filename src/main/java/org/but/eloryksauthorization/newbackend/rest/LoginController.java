package org.but.eloryksauthorization.newbackend.rest;

import org.but.eloryksauthorization.newbackend.data.entity.Person;
import org.but.eloryksauthorization.newbackend.data.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/its/vehicle/user")
public class LoginController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/login")
    @Transactional(readOnly = true)
    public ResponseEntity<?> login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            Person person = personRepository.findByEmailWithPersonRoles(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("email", person.getEmail());
            userInfo.put("pwd", person.getPwd());

            Set<String> roles = person.getPersonRoles().stream()
                    .map(personRole -> personRole.getRole().getRole())
                    .collect(Collectors.toSet());

            userInfo.put("role", roles);

            return ResponseEntity.ok(userInfo);
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }
}
