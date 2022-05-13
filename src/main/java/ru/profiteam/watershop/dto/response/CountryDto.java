package ru.profiteam.watershop.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CountryDto {
    List<CountryDto> countryDtoList;
}
