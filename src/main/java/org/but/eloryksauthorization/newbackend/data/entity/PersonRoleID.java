package org.but.eloryksauthorization.newbackend.data.entity;

import java.io.Serializable;
import java.util.Objects;

public class PersonRoleID implements Serializable {

    private Long person;

    private Long role;

    public PersonRoleID(Long person, Long role) {
        this.person = person;
        this.role = role;
    }

    public PersonRoleID() {}

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonRoleID that)) return false;
        return Objects.equals(getPerson(), that.getPerson()) && Objects.equals(getRole(), that.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPerson(), getRole());
    }
}
