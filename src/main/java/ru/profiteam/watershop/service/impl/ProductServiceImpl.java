package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.ProductBuilder;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.dto.request.CreateProductDto;
import ru.profiteam.watershop.dto.response.ProductDto;
import ru.profiteam.watershop.repository.ManufacturerRepository;
import ru.profiteam.watershop.repository.ProductRepository;
import ru.profiteam.watershop.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    ManufacturerRepository manufacturerRepository;
    ProductBuilder productBuilder;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ManufacturerRepository manufacturerRepository,
                              ProductBuilder productBuilder) {
        this.productRepository = productRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.productBuilder = productBuilder;
    }

    @Override
    public void create(CreateProductDto request) {
        Optional<Manufacturer> manufacturerOpt = manufacturerRepository.findById(request.getManufactureId());
        if (manufacturerOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Product product = productBuilder.build(request, manufacturerOpt.get());
        productRepository.save(product);


    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product item : productList){
            productDtoList.add(productBuilder.build(item));
        }
        return productDtoList;
    }

    @Override
    public ProductDto getById(Long id) {
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return productBuilder.build(productOpt.get());
    }

    @Override
    public void update(Long id, CreateProductDto request) {
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Optional<Manufacturer> manufacturerOpt = manufacturerRepository.findById(request.getManufactureId());
        if (manufacturerOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Product updateProduct = productOpt.get();
        productBuilder.update(updateProduct, request, manufacturerOpt.get());
        productRepository.save(updateProduct);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        productRepository.deleteById(id);
    }
}
