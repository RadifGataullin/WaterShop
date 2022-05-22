package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.CityBuilder;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.*;
import ru.profiteam.watershop.dto.request.CreateProductDto;
import ru.profiteam.watershop.dto.request.CreateUserDto;
import ru.profiteam.watershop.dto.response.ProductDto;
import ru.profiteam.watershop.dto.response.UserDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserBuilderImpl implements UserBuilder {
    CityBuilder cityBuilder;

    @Override
    public UserDto build(User user) {
        return UserDto.builder()
                .id(user.getId())
                .type(user.getType())
                .fullName(user.getFullName())
                .login(user.getLogin())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .city(cityBuilder.build(user.getCity()))
                .build();
    }

    @Override
    public User build(CreateUserDto request, City city, Address address) {
        User user = new User();
        user.setType(request.getType());
        user.setFullName(request.getFullName());
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setCity(city);
        user.setAddress(address);
        user.setCreatedAt(new Date());
        return user;
    }

    @Override
    public void update(User user, CreateUserDto request, City city, Address address) {
        user.setType(request.getType());
        user.setFullName(request.getFullName());
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setCity(city);
        user.setAddress(address);
        user.setUpdatedAt(new Date());
    }
}
