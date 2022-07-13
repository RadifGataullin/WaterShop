package ru.profiteam.watershop.service;

public interface TokenService {
    String buildToken(Long userId);
    Long parseJwt(String token);
}
