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
@Table(name="municipality")
public class Municipality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "municipal_name")
    private String municipalName;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_state", referencedColumnName = "id")
    private State state;
}
