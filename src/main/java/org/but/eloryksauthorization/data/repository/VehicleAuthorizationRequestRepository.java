package org.but.eloryksauthorization.data.repository;

import com.querydsl.core.types.Predicate;
import org.but.eloryksauthorization.data.entity.VehicleAuthorizationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleAuthorizationRequestRepository
        extends JpaRepository<VehicleAuthorizationRequest, Long>, QuerydslPredicateExecutor<VehicleAuthorizationRequest> {

    Page<VehicleAuthorizationRequest> findAll(Predicate predicate, Pageable pageable);
}
