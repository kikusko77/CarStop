package org.but.eloryksauthorization.newbackend.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role implements Serializable {

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    Set<PersonRole> personRoles = new HashSet<>();

    @Id
    @Column(name = "id_role", nullable = false)
    private Long idRole;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

    public Role() {
    }

    public Role(Long idRole, String role, Set<PersonRole> personRoles) {
        this.idRole = idRole;
        this.role = role;
        this.personRoles = personRoles;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<PersonRole> getPersonRoles() {
        return personRoles;
    }

    public void setPersonRoles(Set<PersonRole> personRoles) {
        this.personRoles = personRoles;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", role='" + role + '\'' +
                '}';
    }
}
