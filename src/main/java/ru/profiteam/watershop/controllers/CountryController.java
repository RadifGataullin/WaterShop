package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.dto.response.CountryDto;
import ru.profiteam.watershop.service.CountryService;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("country")
@Tag(name = "Country")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CountryController {

    CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("create")
    public void create(@RequestBody CreateCountryDto request) {
        countryService.create(request);
    }

    @GetMapping("get-all")
    public List<CountryDto> getAll(){
        return countryService.getAll();
    }

    @GetMapping("get-by-id")
    CountryDto getById(Long requestId){
        return countryService.getById(requestId);
    }

    @PutMapping("update")
    void update(Long requestId, CreateCountryDto request){
        countryService.update(requestId, request);
    }

    @DeleteMapping("delete-by-id")
    void deleteById(Long requestId){
        countryService.deleteById(requestId);
    }

}
