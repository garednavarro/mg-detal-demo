package com.mgdental.app.domain.address.repository;

import com.mgdental.app.domain.address.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}
