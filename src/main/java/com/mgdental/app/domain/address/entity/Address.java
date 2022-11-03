package com.mgdental.app.domain.address.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String address;
    @Column(name = "postal_code")
    private Long postalCode;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_municipal")
    private Municipality municipality;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_state")
    private State state;
}
