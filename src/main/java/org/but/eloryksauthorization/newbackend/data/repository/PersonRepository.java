package org.but.eloryksauthorization.newbackend.data.repository;

import org.but.eloryksauthorization.newbackend.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p LEFT JOIN FETCH p.personRoles WHERE p.email = :email")
    Optional<Person> findByEmailWithPersonRoles(@Param("email") String email);

    @Query("SELECT COUNT(p) > 0 FROM Person p WHERE p.email = :email")
    boolean existsByEmail(String email);

    @Query("SELECT p FROM Person p WHERE p.email = :email AND p.idPerson != :id")
    Optional<Person> findByEmailAndIdPersonNot(@Param("email") String email, @Param("id") Long id);
}
