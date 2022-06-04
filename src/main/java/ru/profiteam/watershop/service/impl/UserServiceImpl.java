package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.repository.UserRepository;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl {
    UserRepository userRepository;
    UserBuilder    userBuilder;


    public UserServiceImpl(
                             UserRepository userRepository,
                             UserBuilder userBuilder)
    {
        this.userRepository = userRepository;
        this.userBuilder = userBuilder;
    }
}
