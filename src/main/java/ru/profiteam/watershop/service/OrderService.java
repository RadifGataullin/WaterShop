package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.request.CreateOrderDto;

public interface OrderService {
    void create(CreateOrderDto request);
}
