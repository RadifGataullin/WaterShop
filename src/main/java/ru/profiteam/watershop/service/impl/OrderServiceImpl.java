package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.OrderBuilder;
import ru.profiteam.watershop.builder.ProductToOrderBuilder;
import ru.profiteam.watershop.domain.Order;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.domain.ProductToOrder;
import ru.profiteam.watershop.dto.request.CreateOrderDto;
import ru.profiteam.watershop.dto.request.SelectProductDto;
import ru.profiteam.watershop.dto.response.ProductToOrderDto;
import ru.profiteam.watershop.repository.OrderRepository;
import ru.profiteam.watershop.repository.ProductRepository;
import ru.profiteam.watershop.repository.ProductToOrderRepository;
import ru.profiteam.watershop.service.OrderService;

import java.util.Optional;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    ProductRepository productRepository;
    OrderBuilder orderBuilder;
    ProductToOrderBuilder productToOrderBuilder;
    ProductToOrderRepository productToOrderRepository;

    @Override
    public void create(CreateOrderDto request) {
        Order order = orderBuilder.build(request);
        orderRepository.save(order);

        for (SelectProductDto selectProductDto : request.getProducts()) {
            Optional<Product> productOpt = productRepository.findById(selectProductDto.getProductId());
            if (productOpt.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            ProductToOrder productToOrder = productToOrderBuilder.build(productOpt.get(), order, selectProductDto.getCount());
            productToOrderRepository.save(productToOrder);
        }

    }
}
