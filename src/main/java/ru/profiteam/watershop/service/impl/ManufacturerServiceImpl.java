package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.ManufacterBuilder;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.response.ManufacturerDto;
import ru.profiteam.watershop.repository.ManufacturerRepository;
import ru.profiteam.watershop.service.ManufacturerService;

import java.util.*;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ManufacturerServiceImpl implements ManufacturerService {
    ManufacturerRepository manufacturerRepository;
    ManufacterBuilder manufacterBuilder;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository,
                                   ManufacterBuilder manufacterBuilder) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacterBuilder = manufacterBuilder;
    }

    @Override
    public void create(CreateManufacturerDto request){
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setLogo(request.getLogo());
        manufacturer.setName(request.getName());
        manufacturer.setCreatedAt(new Date());
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public List<ManufacturerDto> getAll() {
        List<Manufacturer> manufacturerList = manufacturerRepository.findAll();
        List<ManufacturerDto> manufacturerDtoList = new ArrayList<>();
        for(Manufacturer item: manufacturerList){
            manufacturerDtoList.add(manufacterBuilder.build(item));
        }
        return manufacturerDtoList;
    }

    @Override
    public ManufacturerDto getById(Long id) {
        Optional<Manufacturer> manufacturerOpt = manufacturerRepository.findById(id);
        if (manufacturerOpt.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Элемент с id = " + id + " не найден");
        }
        return manufacterBuilder.build(manufacturerOpt.get());
    }

    @Override
    public void update(Long id, CreateManufacturerDto request) {
        List<Manufacturer> manufacturerList = manufacturerRepository.findAll();
        for(Manufacturer item: manufacturerList){
            if(Objects.equals(item.getId(), id)){
                item.setName(request.getName());
                item.setLogo(request.getLogo());

            }
        }
        manufacturerRepository.saveAll(manufacturerList);
    }

    @Override
    public void deleteById(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
