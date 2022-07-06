package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.SessionBuilder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.repository.SessionRepository;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SessionServiceImpl {
    SessionRepository sessionRepository;
    SessionBuilder sessionBuilder;


    public SessionServiceImpl(
            SessionRepository sessionRepository,
            SessionBuilder sessionBuilder) {
        this.sessionRepository = sessionRepository;
        this.sessionBuilder = sessionBuilder;
    }
}
