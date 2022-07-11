package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateUserDto;
import ru.profiteam.watershop.dto.response.RegistrationDto;
import ru.profiteam.watershop.dto.response.SessionDto;
import ru.profiteam.watershop.dto.response.UserDto;

import java.util.List;

public interface UserService {
    SessionDto registration(String login, String password);

    UserDto registration(String fullName,
                         String password,
                         String email,
                         int phoneNumber);

    boolean verify(long userId, long code);

    Long createActivationCode(Long userId); //??????????

    void create(RegistrationDto user);

    List<UserDto> getAll();

    void update(Long id, CreateUserDto request);

    void deleteById(Long id);
}


