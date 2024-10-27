package org.but.eloryksauthorization.newbackend.data.repository;

import org.but.eloryksauthorization.newbackend.data.entity.SignKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignKeyRepository extends JpaRepository<SignKey, Long> {
    Optional<SignKey> findByVehicle_StationId(Long stationId);
}
