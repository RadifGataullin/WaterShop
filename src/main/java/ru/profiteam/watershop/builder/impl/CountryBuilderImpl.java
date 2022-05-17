package ru.profiteam.watershop.builder.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.CountryBuilder;
import ru.profiteam.watershop.domain.Country;
import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.dto.response.CountryDto;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CountryBuilderImpl implements CountryBuilder {
    @Override
    public CountryDto build(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }
}
