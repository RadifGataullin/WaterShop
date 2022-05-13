package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.domain.Address;
import ru.profiteam.watershop.dto.request.CreateAddressDto;
import ru.profiteam.watershop.repository.AddressRepository;
import ru.profiteam.watershop.service.AddressService;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void crate(CreateAddressDto request) {
        Address address = new Address();
        address.setFlat(request.getFlat());
        address.setElevator(request.isElevator());
        //...

        addressRepository.save(address);
    }
}
