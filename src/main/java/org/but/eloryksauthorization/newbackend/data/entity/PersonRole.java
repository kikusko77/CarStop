package org.but.eloryksauthorization.newbackend.data.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_has_role")
@IdClass(PersonRoleID.class)
public class PersonRole {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person",referencedColumnName = "id_person")
    Person person;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    Role role;

    @Column(name = "started_at", nullable = false)
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    public PersonRole(Person person, Role role, LocalDateTime startedAt, LocalDateTime endedAt, LocalDateTime expirationDate) {
        this.person = person;
        this.role = role;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.expirationDate = expirationDate;
    }

    public PersonRole() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "PersonRole{" +
                ", person=" + person +
                ", role=" + role +
                ", startedAt=" + startedAt +
                ", endedAt=" + endedAt +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
