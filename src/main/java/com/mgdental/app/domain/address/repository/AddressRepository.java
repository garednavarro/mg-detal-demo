package com.mgdental.app.domain.address.repository;

import com.mgdental.app.domain.address.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
