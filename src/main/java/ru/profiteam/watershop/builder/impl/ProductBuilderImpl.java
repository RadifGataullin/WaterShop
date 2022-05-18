package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.ManufacterBuilder;
import ru.profiteam.watershop.builder.ProductBuilder;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.dto.request.CreateProductDto;
import ru.profiteam.watershop.dto.response.ManufacturerDto;
import ru.profiteam.watershop.dto.response.ProductDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductBuilderImpl implements ProductBuilder {

    ManufacterBuilder manufacterBuilder;

    @Override
    public ProductDto build(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .productType(product.getProductType())
                .productContainerMaterialType(product.getProductContainerMaterialType())
                .price(product.getPrice())
                .volume(product.getVolume())
                .manufacturer(manufacterBuilder.build(product.getManufacturer()))
                .build();
    }

    @Override
    public Product build(CreateProductDto request, Manufacturer manufacturer) {
        Product product = new Product();
        product.setName(request.getName());
        product.setProductType(request.getProductType());
        product.setProductContainerMaterialType(request.getProductContainerMaterialType());
        product.setPrice(request.getPrice());
        product.setVolume(request.getVolume());
        product.setCreatedAt(new Date());
        product.setManufacturer(manufacturer);
        return product;
    }

    @Override
    public void update(Product product, CreateProductDto request, Manufacturer manufacturer) {
        product.setName(request.getName());
        product.setProductType(request.getProductType());
        product.setProductContainerMaterialType(request.getProductContainerMaterialType());
        product.setPrice(request.getPrice());
        product.setVolume(request.getVolume());
        product.setManufacturer(manufacturer);
        product.setUpdatedAt(new Date());
    }
}