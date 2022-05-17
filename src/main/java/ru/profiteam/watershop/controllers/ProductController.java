package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.dto.request.CreateProductDto;
import ru.profiteam.watershop.dto.response.CountryDto;
import ru.profiteam.watershop.dto.response.ProductDto;
import ru.profiteam.watershop.service.ProductService;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("product")
@Tag(name = "Product")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("create")
    public void create(@RequestBody CreateProductDto request) {
        productService.create(request);
    }

    @GetMapping("get-all")
    public List<ProductDto> getAll(){
        return productService.getAll();
    }

    @GetMapping("get-by-id")
    ProductDto getById(Long id){
        return productService.getById(id);
    }

    @PutMapping("update")
    void update(Long id, @RequestBody CreateProductDto request){
        productService.update(id, request);
    }

    @DeleteMapping("delete-by-id")
    void deleteById(Long id){
        productService.deleteById(id);
    }
}
