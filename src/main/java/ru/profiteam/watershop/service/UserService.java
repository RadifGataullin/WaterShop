package ru.profiteam.watershop.service;

import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.response.SessionDto;
import ru.profiteam.watershop.dto.response.UserDto;

public interface UserService {
    SessionDto auth(String login, String password);
    UserDto registration(String fullName,
                         String password,
                         String email,
                         int phoneNumber);
    boolean verify(long userId, long code);
    Long createActivationCode(Long userId); //?????????

}
