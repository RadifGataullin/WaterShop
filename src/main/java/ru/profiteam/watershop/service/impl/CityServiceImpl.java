package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.dto.request.CreateAddressDto;
import ru.profiteam.watershop.dto.request.CreateCityDto;
import ru.profiteam.watershop.repository.CityRepository;
import ru.profiteam.watershop.service.CityService;

//@Service
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class CityServiceImpl<cityRepository> implements CityService {
//    CityRepository cityRepository ;
//
//    @Autowired
//    public cityRepository CityServiceImpl(CityRepository, cityRepository) {
//        this.cityRepository = cityRepository}
//
//    @Override
//    public void create(CreateCityDto request) {
//
//    }
//
//
//}
