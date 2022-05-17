package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.CityBuilder;
import ru.profiteam.watershop.domain.City;
import ru.profiteam.watershop.domain.Country;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.dto.request.CreateCityDto;
import ru.profiteam.watershop.dto.response.CityDto;
import ru.profiteam.watershop.repository.CityRepository;
import ru.profiteam.watershop.repository.CountryRepository;
import ru.profiteam.watershop.service.CityService;

import java.util.*;
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CityServiceImpl implements CityService {
    CityRepository cityRepository;
    CityBuilder cityBuilder;
    CountryRepository countryRepository;

    public CityServiceImpl(CityRepository cityRepository,
                           CityBuilder cityBuilder,
                           CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.cityBuilder = cityBuilder;
        this.countryRepository = countryRepository;
    }


    @Override
    public void create(CreateCityDto request) {
        City city = new City();
        city.setName(request.getName());
        city.setCreatedAt(new Date());

        Country country = countryRepository.getById(request.getCountryId());
        city.setCountry(country);

        cityRepository.save(city);
    }

    @Override
    public List<CityDto> getAll() {
        List<City> cityList = cityRepository.findAll();
        List<CityDto> cityDtoList = new ArrayList<>();
        for(City item : cityList){
            cityDtoList.add(cityBuilder.build(item));
        }
        return cityDtoList;
    }

    @Override
    public CityDto getById(Long id) {
        Optional<City> cityOpt = cityRepository.findById(id);
        if (cityOpt.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Элемент с id = " + id + " не найден");
        }
        return cityBuilder.build(cityOpt.get());
    }

    @Override
    public void update(Long id, CreateCityDto request) {
        List<City> cityList = cityRepository.findAll();

        for(City item: cityList){
            if(Objects.equals(item.getId(), id)){
                item.setName(request.getName());

                Country country = new Country();
                country.setId(item.getCountry().getId());
                country.setName(item.getCountry().getName());
                item.setCountry(country);
            }
        }
        cityRepository.saveAll(cityList);
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }
}
