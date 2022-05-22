package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateUserDto;

public interface UserService {
    void create(CreateUserDto request);
}
