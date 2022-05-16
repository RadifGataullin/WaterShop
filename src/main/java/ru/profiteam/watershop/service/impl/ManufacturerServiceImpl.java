package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.response.ManufacturerDto;
import ru.profiteam.watershop.repository.ManufacturerRepository;
import ru.profiteam.watershop.service.ManufacturerService;

import java.util.ArrayList;
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
            ManufacturerDto manufacturerDto = new ManufacturerDto();
            manufacturerDto.setId(item.getId());
            manufacturerDto.setName(item.getName());
            manufacturerDto.setLogo(item.getLogo());
            manufacturerDtoList.add(manufacturerDto);
        }
        return manufacturerDtoList;
    }

    @Override
    public ManufacturerDto getById(Long requestId) {
        ManufacturerDto manufacturerDto = new ManufacturerDto();
        manufacturerDto.setId(manufacturerRepository.getById(requestId).getId());
        manufacturerDto.setName(manufacturerRepository.getById(requestId).getName());
        manufacturerDto.setLogo(manufacturerRepository.getById(requestId).getLogo());
        return manufacturerDto;
    }

    @Override
    public void update(Long requestId, CreateManufacturerDto request) {
        List<Manufacturer> manufacturerList = manufacturerRepository.findAll();
        for(Manufacturer item: manufacturerList){
            if(item.getId() == requestId){
                item.setName(request.getName());
                item.setLogo(request.getLogo());
            }
        }
        manufacturerRepository.saveAll(manufacturerList);
    }

    @Override
    public void deleteById(Long requestId) {
        manufacturerRepository.deleteById(requestId);
    }
}
