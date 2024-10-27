package org.but.eloryksauthorization.newbackend.data.repository;

import org.but.eloryksauthorization.newbackend.data.entity.SpeedLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpeedLimitRepository extends JpaRepository<SpeedLimit, Long> {
    Optional<SpeedLimit> findByVehicle_StationId(Long stationId);
}
