package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.City;
import ru.profiteam.watershop.dto.response.CityDto;

public interface CityBuilder {
    CityDto build(City city);
}
