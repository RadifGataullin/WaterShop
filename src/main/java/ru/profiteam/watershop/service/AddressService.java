package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateAddressDto;

public interface AddressService {

    void create(CreateAddressDto request);
}