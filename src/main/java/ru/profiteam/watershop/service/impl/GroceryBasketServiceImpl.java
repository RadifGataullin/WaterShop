package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.GroceryBasketBuilder;
import ru.profiteam.watershop.dto.request.CreateGroceryBasketDto;
import ru.profiteam.watershop.dto.response.GroceryBasketDto;
import ru.profiteam.watershop.repository.GroceryBasketRepository;
import ru.profiteam.watershop.service.GroceryBasketService;

import java.util.List;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroceryBasketServiceImpl implements GroceryBasketService {
    GroceryBasketRepository groceryBasketRepository;
    GroceryBasketBuilder groceryBasketBuilder;

    public GroceryBasketServiceImpl(GroceryBasketRepository groceryBasketRepository, GroceryBasketBuilder groceryBasketBuilder) {
        this.groceryBasketRepository = groceryBasketRepository;
        this.groceryBasketBuilder = groceryBasketBuilder;
    }

    @Override
    public void create(CreateGroceryBasketDto request) {

    }

    @Override
    public List<GroceryBasketDto> getAll() {
        return null;
    }

    @Override
    public GroceryBasketDto getById(Long id) {
        return null;
    }

    @Override
    public void update(Long id, GroceryBasketDto request) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
