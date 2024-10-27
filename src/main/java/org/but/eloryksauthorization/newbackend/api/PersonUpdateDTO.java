package org.but.eloryksauthorization.newbackend.api;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class PersonUpdateDTO {

    @Valid
    Set<PersonRoleDTO> personRoles = new HashSet<>();

    private Long idPerson;

    @NotEmpty(message = "Email must not be null")
    private String email;

    private String givenName;

    private String familyName;

    private String nickname;

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Set<PersonRoleDTO> getPersonRoles() {
        return personRoles;
    }

    public void setPersonRoles(Set<PersonRoleDTO> personRoles) {
        this.personRoles = personRoles;
    }

}