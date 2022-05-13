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

import java.util.Date;
import java.util.List;

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
        /// преобразовать лист контри в контри дто и ретернуть
        return null;
    }
}
