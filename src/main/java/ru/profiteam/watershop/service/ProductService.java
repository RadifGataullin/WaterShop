package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateProductDto;
import ru.profiteam.watershop.dto.response.ProductDto;

import java.util.List;

public interface ProductService {

    /**
     * Создание сущности Product
     *
     * @param request - модель создания
     */
    void create(CreateProductDto request);

    List<ProductDto> getAll();

    ProductDto getById(Long id);

    void update(Long id, CreateProductDto request);

    void deleteById(Long id);
}
