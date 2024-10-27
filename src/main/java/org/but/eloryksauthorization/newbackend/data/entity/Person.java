package org.but.eloryksauthorization.newbackend.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person implements Serializable {

    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY, orphanRemoval = true)
    Set<PersonRole> personRoles = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long idPerson;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "given_name", length = 45)
    private String givenName;

    @Column(name = "family_name", length = 45)
    private String familyName;

    @Column(name = "nickname", length = 45)
    private String nickname;

    @Column(name = "pwd", nullable = false)
    private String pwd;

    public Person() {
    }

    public Person(Long idPerson, String email, String givenName, String familyName, String nickname, String pwd, Set<PersonRole> personRoles) {
        this.idPerson = idPerson;
        this.email = email;
        this.givenName = givenName;
        this.familyName = familyName;
        this.nickname = nickname;
        this.pwd = pwd;
        this.personRoles = personRoles;
    }

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Set<PersonRole> getPersonRoles() {
        return personRoles;
    }

    public void setPersonRoles(Set<PersonRole> personRoles) {
        this.personRoles = personRoles;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", email='" + email + '\'' +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}

