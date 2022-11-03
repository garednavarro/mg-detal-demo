package com.mgdental.app.domain.address.service;

import com.mgdental.app.domain.address.entity.Municipality;
import com.mgdental.app.domain.address.repository.MunicipalRepository;
import com.mgdental.app.exceptions.AppException;
import com.mgdental.app.exceptions.Error;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MunicipalServiceImpl implements MunicipalService{

    private MunicipalRepository municipalRepository;
    @Override
    public ResponseEntity<Municipality> getMunicipality(Integer id) {
        return ResponseEntity.ok(municipalRepository.findById(id).orElseThrow(() -> new AppException(Error.MUNICIPALITY_NOT_FOUND)));
    }

    @Override
    public ResponseEntity<List<Municipality>> getMunicipalityByState(Integer id) {
        return ResponseEntity.status(200).body(municipalRepository.findMunicipalitiesByStateId(id).orElseThrow(() -> new AppException(Error.MUNICIPALITY_NOT_FOUND)));
    }

    @Override
    public ResponseEntity<List<Municipality>> getAllMunicipalities() {
        return ResponseEntity.status(200).body(municipalRepository.findAll());
    }
}
