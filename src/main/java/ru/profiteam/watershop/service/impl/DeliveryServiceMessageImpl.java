package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.DeliveryServiceMassageBuilder;
import ru.profiteam.watershop.repository.DeliveryServiceMassageRepository;
import ru.profiteam.watershop.service.DeliveryService;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeliveryServiceMessageImpl implements DeliveryService {

    DeliveryServiceMassageRepository deliveryServiceMassageRepository;
    DeliveryServiceMassageBuilder deliveryServiceMassageBuilder;

    @Autowired
    public DeliveryServiceMessageImpl(
            DeliveryServiceMassageRepository deliveryServiceMassageRepository,
            DeliveryServiceMassageBuilder deliveryServiceMassageBuilder) {
        this.deliveryServiceMassageRepository = deliveryServiceMassageRepository;
        this.deliveryServiceMassageBuilder = deliveryServiceMassageBuilder;
    }
}
