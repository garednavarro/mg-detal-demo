package com.mgdental.app.domain.patient.entity;

import com.mgdental.app.domain.address.entity.Address;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "patient_name")
    private String patientName;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private Date birthDate;

    @Column
    private String curp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address address;
}
