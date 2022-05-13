package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateCountryDto;

public interface CountryService {
    void create(CreateCountryDto request);
}
