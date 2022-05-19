package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.SellerBuilder;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.Seller;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateSellerDto;
import ru.profiteam.watershop.dto.response.SellerDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SellerBuilderImpl implements SellerBuilder {
    UserBuilder userBuilder;


    @Override
    public SellerDto build(Seller seller) {
        return SellerDto.builder()
                .id(seller.getId())
                .name(seller.getName())
                .user(userBuilder.build(seller.getUser()))
                .build();
    }

    @Override
    public Seller build(CreateSellerDto request, User user) {
        Seller seller = new Seller();
        seller.setName(request.getName());
        seller.setInn(request.getInn());
        seller.setBik(request.getBik());
        seller.setDescription(request.getDescription());
        seller.setCreatedAt(new Date());
        seller.setUser(user);
        return seller;
    }

    @Override
    public void update(Seller seller, CreateSellerDto request, User user) {
        seller.setName(request.getName());
        seller.setInn(request.getInn());
        seller.setBik(request.getBik());
        seller.setDescription(request.getDescription());
        seller.setUser(user);
        seller.setUpdatedAt(new Date());
    }
}
