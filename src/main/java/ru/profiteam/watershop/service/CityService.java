package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateAddressDto;
import ru.profiteam.watershop.dto.request.CreateCityDto;

public interface CityService {

    void create(CreateCityDto request);
}
