package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.response.ApproveCodeDto;
import ru.profiteam.watershop.dto.response.AuthDto;
import ru.profiteam.watershop.dto.response.SecurityAuthDto;
import ru.profiteam.watershop.dto.response.UserDto;

import java.util.List;

public interface AuthService {
    SecurityAuthDto get(AuthDto authDto);
}