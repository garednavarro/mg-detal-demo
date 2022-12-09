package com.mgdental.app.domain.address.service;

import com.mgdental.app.domain.address.entity.State;
import com.mgdental.app.domain.address.repository.StateRepository;
import com.mgdental.app.exceptions.AppException;
import com.mgdental.app.exceptions.Error;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StateServiceImpl implements StateService{

    private StateRepository stateRepository;
    @Override
    public ResponseEntity<State> findById(Integer id) {
        return ResponseEntity.ok(
                stateRepository
                        .findById(id)
                        .orElseThrow(() -> new AppException(Error.STATE_NOT_FOUND))
        );
    }

    @Override
    public ResponseEntity<List<State>> findAllStates() {
        return ResponseEntity.ok(stateRepository.findAll());
    }
}
