package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import ru.profiteam.watershop.dto.request.CreateCityDto;
import ru.profiteam.watershop.dto.response.CityDto;
import ru.profiteam.watershop.service.CityService;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("city")
@Tag(name = "City")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CityController {
    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("create")
    public void create(@RequestBody CreateCityDto request) {
        cityService.create(request);
    }

    @GetMapping("get-all")
    public List<CityDto> getAll(){
        return cityService.getAll();
    }

    @GetMapping("get-by-id")
    CityDto getById(Long id){
        return cityService.getById(id);
    }

    @PutMapping("update")
    void update(Long id, @RequestBody CreateCityDto request){
        cityService.update(id, request);
    }

    @DeleteMapping("delete-by-id")
    void deleteById(Long id){
        cityService.deleteById(id);
    }
}
