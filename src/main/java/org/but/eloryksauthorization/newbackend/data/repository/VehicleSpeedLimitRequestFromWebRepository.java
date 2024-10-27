package org.but.eloryksauthorization.newbackend.data.repository;

import org.but.eloryksauthorization.newbackend.data.entity.VehicleSpeedLimitRequestFromWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleSpeedLimitRequestFromWebRepository extends JpaRepository<VehicleSpeedLimitRequestFromWeb, Long> {
}