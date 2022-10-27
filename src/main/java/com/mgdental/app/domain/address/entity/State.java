package com.mgdental.app.domain.address.entity;

import javax.persistence.*;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "state_name")
    private String stateName;
}