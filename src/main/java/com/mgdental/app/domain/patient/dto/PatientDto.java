package com.mgdental.app.domain.patient.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mgdental.app.domain.address.entity.Address;
import lombok.*;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
@Builder
@JsonTypeName("petient")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
public class PatientDto {

    private String patientName;

    private String email;

    private String phone;

    private Date birthDate;

    private String curp;

    private Address address;

}
