package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import ru.profiteam.watershop.annotation.BaseApiResponse;
import ru.profiteam.watershop.annotation.BaseApiResponseEmpty;
import ru.profiteam.watershop.dto.request.CreateUserDto;
import ru.profiteam.watershop.dto.response.RegistrationDto;
import ru.profiteam.watershop.dto.response.UserDto;
import ru.profiteam.watershop.service.UserService;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("user")
@Tag(name = "User")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @BaseApiResponseEmpty
    @PostMapping
    public void create(@RequestBody RegistrationDto request) {
        userService.create(request);
    }

    @BaseApiResponse
    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @BaseApiResponseEmpty
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CreateUserDto request) {
        userService.update(id, request);
    }

    @BaseApiResponseEmpty
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
