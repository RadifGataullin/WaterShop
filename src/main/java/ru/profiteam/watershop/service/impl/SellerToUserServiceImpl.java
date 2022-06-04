package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.SellerToUserBuilder;
import ru.profiteam.watershop.repository.SellerToUserRepository;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SellerToUserServiceImpl {
    SellerToUserRepository sellerToUserRepository;
    SellerToUserBuilder sellerToUserBuilder;

    @Autowired
    public SellerToUserServiceImpl(
                                     SellerToUserRepository sellerToUserRepository,
                                     SellerToUserBuilder sellerToUserBuilder)
    {
        this.sellerToUserRepository = sellerToUserRepository;
        this.sellerToUserBuilder = sellerToUserBuilder;
    }
}
