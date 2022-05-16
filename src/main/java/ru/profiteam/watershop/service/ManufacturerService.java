package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.response.ManufacturerDto;

import java.util.List;

public interface ManufacturerService {

    void create(CreateManufacturerDto request);

    List<ManufacturerDto> getAll();
}
