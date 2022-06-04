package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.SellerBuilder;
import ru.profiteam.watershop.repository.SellerRepository;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SellerServiceImpl {

    SellerRepository sellerRepository;
    SellerBuilder    sellerBuilder;

    @Autowired
    public SellerServiceImpl(
                             SellerRepository sellerRepository,
                             SellerBuilder sellerBuilder)
    {
        this.sellerRepository = sellerRepository;
        this.sellerBuilder    = sellerBuilder;
    }
}
