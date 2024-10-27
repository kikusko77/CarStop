package org.but.eloryksauthorization.newbackend.data.repository;


import org.but.eloryksauthorization.newbackend.data.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
