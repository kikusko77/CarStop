package org.but.eloryksauthorization.newbackend.data.repository;

import org.but.eloryksauthorization.newbackend.data.entity.PersonRole;
import org.but.eloryksauthorization.newbackend.data.entity.PersonRoleID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole, PersonRoleID> {
}
