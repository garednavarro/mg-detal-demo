package com.mgdental.app.domain.address.service;

import com.mgdental.app.domain.address.entity.Address;
import com.mgdental.app.domain.address.repository.AddressRepository;
import com.mgdental.app.exceptions.AppException;
import com.mgdental.app.exceptions.Error;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    @Override
    public Address getAddress(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new AppException(Error.LOGING_INFO_INVALID));
    }
}
