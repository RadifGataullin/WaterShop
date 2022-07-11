package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import ru.profiteam.watershop.annotation.BaseApiResponse;
import ru.profiteam.watershop.annotation.BaseApiResponseEmpty;
import ru.profiteam.watershop.dto.request.CreateOrderDto;
import ru.profiteam.watershop.dto.response.OrderDto;
import ru.profiteam.watershop.service.OrderService;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("order")
@Tag(name = "Order")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @BaseApiResponseEmpty
    @PostMapping("create")
    public void create(@RequestBody CreateOrderDto request) {
        orderService.create(request);
    }

    @BaseApiResponse
    @GetMapping
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @BaseApiResponse
    @GetMapping("/{id}")
    public List<OrderDto> getByUserId(@PathVariable Long id) {
        return orderService.getByUserId(id);
    }
}
