package com.mgdental.app.domain.address.controller;

import com.mgdental.app.domain.address.entity.Municipality;
import com.mgdental.app.domain.address.entity.State;
import com.mgdental.app.domain.address.service.MunicipalServiceImpl;
import com.mgdental.app.domain.address.service.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    MunicipalServiceImpl municipalService;
    StateServiceImpl stateService;

    @Autowired
    public AddressController(MunicipalServiceImpl  municipalService, StateServiceImpl stateService){
        this.municipalService = municipalService;
        this.stateService = stateService;
    }

    @GetMapping("/municipalities/all")
    public ResponseEntity<List<Municipality>> getAllMunicipalities(){
        return municipalService.getAllMunicipalities();
    }

    @GetMapping("/municipalities/{id}")
    public ResponseEntity<List<Municipality>> getMunicipalitiesByStateId(@PathVariable Integer id){
        return municipalService.getMunicipalityByState(id);
    }

    @GetMapping("/states/all")
    public ResponseEntity<List<State>> getAllStates(){
        return stateService.findAllStates();
    }

    @GetMapping("/states/{id_state}")
    public ResponseEntity<State> getState(@RequestParam Integer id_state){
        return stateService.findById(id_state);
    }

}
