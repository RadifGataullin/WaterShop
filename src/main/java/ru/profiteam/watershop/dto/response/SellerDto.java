package ru.profiteam.watershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerDto {
    Long id;
    String name;
    UserDto user;
    String inn;
    String bik;
    String description;
}
