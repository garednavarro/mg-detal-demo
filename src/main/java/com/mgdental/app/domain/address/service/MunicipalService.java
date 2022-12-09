package com.mgdental.app.domain.address.service;

import com.mgdental.app.domain.address.entity.Municipality;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MunicipalService {
    ResponseEntity<Municipality> getMunicipality(Integer id);
    ResponseEntity<List<Municipality>> getMunicipalityByState(Integer id);
    ResponseEntity<List<Municipality>> getAllMunicipalities();

}
