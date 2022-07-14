package ru.profiteam.watershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {
    Long id;
    String loginDate;
    String logoutDate;
    UserDto user;
    String token;
}
