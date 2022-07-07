package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.SellerBuilder;
import ru.profiteam.watershop.domain.Seller;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateSellerDto;
import ru.profiteam.watershop.repository.SellerRepository;
import ru.profiteam.watershop.repository.UserRepository;
import ru.profiteam.watershop.service.SellerService;

import java.util.Optional;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    SellerRepository sellerRepository;
    SellerBuilder sellerBuilder;

    @Override
    public void create(CreateSellerDto request) {
        Seller seller = sellerBuilder.build(request);
        sellerRepository.save(seller);
    }
}
