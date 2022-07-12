package ru.profiteam.watershop.controllers.base;

import javax.servlet.http.HttpServletRequest;

public abstract class AuthorizationController {

    protected Long userId;

    public AuthorizationController(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        var a = token;
    }
}
