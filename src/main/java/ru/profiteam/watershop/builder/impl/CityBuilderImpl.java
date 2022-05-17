package ru.profiteam.watershop.builder.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.CityBuilder;
import ru.profiteam.watershop.domain.City;
import ru.profiteam.watershop.dto.response.CityDto;
import ru.profiteam.watershop.dto.response.CountryDto;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CityBuilderImpl implements CityBuilder {

    @Override
    public CityDto build(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .country(CountryDto.builder()
                        .id(city.getCountry().getId())
                        .name(city.getCountry().getName())
                        .build())
                .build();
    }
}
