package org.but.eloryksauthorization.newbackend.data.repository;

import org.but.eloryksauthorization.newbackend.data.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
