package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.ApproveCode;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.RegistrationDto;
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

    @Autowired
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

    @Override
    public void create(RegistrationDto request) {
        if (request.getPassword().length() < 6) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
        var entityUser = userBuilder.regBuild(request);


        userRepository.save(entityUser);

    }
}
