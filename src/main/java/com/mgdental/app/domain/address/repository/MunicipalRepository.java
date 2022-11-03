package com.mgdental.app.domain.address.repository;

import com.mgdental.app.domain.address.entity.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MunicipalRepository extends JpaRepository<Municipality, Integer> {
    @Query("SELECT u FROM Municipality u WHERE u.idState=:stateId")
    Optional<List<Municipality>> findMunicipalitiesByStateId(@Param("stateId") Integer stateId);
}
