package org.but.eloryksauthorization.newbackend.data.repository;

import org.but.eloryksauthorization.newbackend.data.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Optional<Position> findByVehicle_StationId(Long stationId);
}
