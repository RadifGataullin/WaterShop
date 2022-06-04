package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.request.CreateSellerDto;

public interface SellerService {
    void create(CreateSellerDto request);
}
