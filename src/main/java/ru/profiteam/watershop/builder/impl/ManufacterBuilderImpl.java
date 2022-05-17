package ru.profiteam.watershop.builder.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.ManufacterBuilder;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.dto.response.ManufacturerDto;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ManufacterBuilderImpl implements ManufacterBuilder {

    @Override
    public ManufacturerDto build(Manufacturer manufacturer) {
        return ManufacturerDto.builder()
                .id(manufacturer.getId())
                .logo(manufacturer.getLogo())
                .name(manufacturer.getName())
                .build();
    }
}
