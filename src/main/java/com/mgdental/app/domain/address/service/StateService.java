package com.mgdental.app.domain.address.service;

import com.mgdental.app.domain.address.entity.State;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StateService {

    ResponseEntity<State> findById(Integer id);

    ResponseEntity<List<State>> findAllStates();
}
