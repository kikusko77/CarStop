package org.but.eloryksauthorization.newbackend.rest;
import jakarta.validation.Valid;
import org.but.eloryksauthorization.newbackend.api.PersonCreateDTO;
import org.but.eloryksauthorization.newbackend.api.PersonDTO;
import org.but.eloryksauthorization.newbackend.api.PersonUpdateDTO;
import org.but.eloryksauthorization.newbackend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/its/vehicle")
public class UserController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/allUsers", produces = "application/json")
    public ResponseEntity<List<PersonDTO>> getAllUsers(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                        LocalDateTime timestamp) {
        List<PersonDTO> personDTOS = personService.findAll();
        return new ResponseEntity<>(personDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/createUser", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PersonCreateDTO> createUser(@Valid @RequestBody PersonCreateDTO personDTO) {
        PersonCreateDTO createdPerson = personService.save(personDTO);
        return ResponseEntity.ok(createdPerson);
    }

    @PutMapping(value = "/updateUser", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PersonUpdateDTO> updateUser(@Valid @RequestBody PersonUpdateDTO personDTO) {
        PersonUpdateDTO updatedPerson = personService.update(personDTO);
        return  ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping(value = "/deleteUser", produces = "application/json")
    public ResponseEntity<Integer> deleteById(@RequestParam(name = "users", required = false) List<Long> userList) {
        personService.deleteById(userList);
        return  ResponseEntity.noContent().build();
    }
}
