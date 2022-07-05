package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.GroceryBasket;
import ru.profiteam.watershop.dto.response.GroceryBasketDto;

public interface GroceryBasketBuilder {
    GroceryBasketDto build(GroceryBasket groceryBasket);

    GroceryBasket build(GroceryBasketDto request);

    void update(GroceryBasket groceryBasket, GroceryBasketDto request);
}
