package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.ProductToOrderBuilder;
import ru.profiteam.watershop.repository.ProductToOrderRepository;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductToOrderServiceImpl {
    ProductToOrderRepository productToOrderRepository;
    ProductToOrderBuilder productToOrderBuilder;

    @Autowired
    public ProductToOrderServiceImpl(ProductToOrderRepository productToOrderRepository,
                                     ProductToOrderBuilder productToOrderBuilder) {
        this.productToOrderRepository = productToOrderRepository;
        this.productToOrderBuilder = productToOrderBuilder;
    }
}
