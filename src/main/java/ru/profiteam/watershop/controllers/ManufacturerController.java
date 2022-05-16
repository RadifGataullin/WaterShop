package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.response.CountryDto;
import ru.profiteam.watershop.dto.response.ManufacturerDto;
import ru.profiteam.watershop.service.ManufacturerService;

import java.util.List;

@RestController
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequestMapping("manufacturer")
@Tag(name = "Manufacturer")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ManufacturerController {

    ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping("create")
    public void create(@RequestBody CreateManufacturerDto request){
        manufacturerService.create(request);
    }

    @GetMapping("get-all")
    public List<ManufacturerDto> getAll(){
        return manufacturerService.getAll();
    }

    @GetMapping("get-by-id")
    ManufacturerDto getById(Long requestId){
        return manufacturerService.getById(requestId);
    }

    @PutMapping("update")
    void update(Long requestId, CreateManufacturerDto request){
        manufacturerService.update(requestId, request);
    }

    @DeleteMapping("delete-by-id")
    void deleteById(Long requestId){
        manufacturerService.deleteById(requestId);
    }
}
