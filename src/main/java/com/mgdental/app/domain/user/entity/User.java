package com.mgdental.app.domain.user.entity;

import com.mgdental.app.domain.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username", nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(name = "id_speciality")
    private Integer idSpeciality;
    @Column
    private String email;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column
    private Boolean activo;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles  = new HashSet<>();

}



//, uniqueConstraints = {
//@UniqueConstraint(columnNames = "username"),
//@UniqueConstraint(columnNames = "email")
//}

/*@JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))*/