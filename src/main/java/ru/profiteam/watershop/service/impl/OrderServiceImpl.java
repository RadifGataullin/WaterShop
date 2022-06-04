package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.OrderBuilder;
import ru.profiteam.watershop.repository.OrderRepository;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl {
    OrderRepository orderRepository;
    OrderBuilder orderBuilder;

    @Autowired
    public OrderServiceImpl(
                            OrderRepository orderRepository,
                            OrderBuilder orderBuilder)
    {
        this.orderRepository = orderRepository;
        this.orderBuilder = orderBuilder;
    }
}
