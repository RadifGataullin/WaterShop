package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.domain.Country;
import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.dto.response.CountryDto;
import ru.profiteam.watershop.repository.CountryRepository;
import ru.profiteam.watershop.service.CountryService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public void create(CreateCountryDto request) {
        Country country = new Country();
        country.setName(request.getName());
        country.setCreatedAt(new Date());
        countryRepository.save(country);
    }

    @Override
    public List<CountryDto> getAll() {
        List<Country> countryList = countryRepository.findAll();
        List<CountryDto> countryDtoList = new ArrayList<>();
        for (Country item : countryList) {
            CountryDto countryDto = new CountryDto();
            countryDto.setId(item.getId());
            countryDto.setName(item.getName());
            countryDtoList.add(countryDto);
        }
        return countryDtoList;
    }

    @Override
    public CountryDto getById(Long requestId) {
        CountryDto countryDto = new CountryDto();
        countryDto.setName(countryRepository.getById(requestId).getName());
        countryDto.setId(countryRepository.getById(requestId).getId());
        return countryDto;
    }

    @Override
    public void update(Long requestId, CreateCountryDto request) {
        List<Country> countryList = countryRepository.findAll();
        for(Country item: countryList){
            if(Objects.equals(item.getId(), requestId)){
                item.setName(request.getName());
            }
        }
        countryRepository.saveAll(countryList);
    }

    @Override
    public void deleteById(Long requestId) {
        countryRepository.deleteById(requestId);
    }


}
