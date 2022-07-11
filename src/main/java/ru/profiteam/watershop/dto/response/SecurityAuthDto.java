package ru.profiteam.watershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityAuthDto {

    private UserDto user;
    private String token;
}
