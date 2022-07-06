package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.dto.response.SessionDto;
import ru.profiteam.watershop.dto.response.UserDto;
import ru.profiteam.watershop.repository.UserRepository;
import ru.profiteam.watershop.service.UserService;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserBuilder userBuilder;


    public UserServiceImpl(
            UserRepository userRepository,
            UserBuilder userBuilder) {
        this.userRepository = userRepository;
        this.userBuilder = userBuilder;
    }

    @Override
    public SessionDto auth(String login, String password) {
        return null;
    }

    @Override
    public UserDto registration(String fullName, String password, String email, int phoneNumber) {
        return null;
    }

    @Override
    public boolean verify(long userId, long code) {
        return false;
    }

    @Override
    public Long createActivationCode(Long userId) {
        return null;
    }
}
