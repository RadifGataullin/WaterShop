package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.service.ManufacturerService;

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
}
