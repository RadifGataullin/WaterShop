package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.GroceryBasketBuilder;
import ru.profiteam.watershop.domain.GroceryBasket;
import ru.profiteam.watershop.dto.response.GroceryBasketDto;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GroceryBasketBuilderImpl  implements GroceryBasketBuilder {
    @Override
    public GroceryBasketDto build(GroceryBasket groceryBasket) {
        return null;
    }

    @Override
    public GroceryBasket build(GroceryBasketDto request) {
        return null;
    }

    @Override
    public void update(GroceryBasket groceryBasket, GroceryBasketDto request) {

    }
}
