package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.dto.response.ManufacturerDto;

public interface ManufacterBuilder {

    ManufacturerDto build(Manufacturer manufacturer);
}
