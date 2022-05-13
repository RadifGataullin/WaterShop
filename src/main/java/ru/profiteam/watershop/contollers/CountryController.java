package ru.profiteam.watershop.contollers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.service.CountryService;

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
    public void create(CreateCountryDto request) {
        countryService.create(request);
    }
}
