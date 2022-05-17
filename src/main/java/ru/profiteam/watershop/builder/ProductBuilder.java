package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.dto.request.CreateProductDto;
import ru.profiteam.watershop.dto.response.ProductDto;

public interface ProductBuilder {

    ProductDto build(Product product);

    Product build(CreateProductDto request, Manufacturer manufacturer);

    void update(Product product, CreateProductDto request, Manufacturer manufacturer);
}
