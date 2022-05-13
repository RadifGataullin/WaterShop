package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.response.ManufacturerDto;
import ru.profiteam.watershop.repository.ManufacturerRepository;
import ru.profiteam.watershop.service.ManufacturerService;

import java.util.Date;
import java.util.List;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ManufacturerServiceImpl implements ManufacturerService {

    ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public void crate(CreateManufacturerDto request){
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setLogo(request.getLogo());
        manufacturer.setName(request.getName());
        manufacturer.setCreatedAt(new Date());
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public List<ManufacturerDto> getAll() {
        manufacturerRepository.findAll();

    }
}
