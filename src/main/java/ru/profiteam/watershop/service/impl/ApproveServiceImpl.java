package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.ApproveCodeBuilder;
import ru.profiteam.watershop.dto.request.CreateApproveCodeDto;
import ru.profiteam.watershop.repository.ApproveCodeRepository;
import ru.profiteam.watershop.service.ApproveCodeService;

import java.util.Random;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApproveServiceImpl implements ApproveCodeService {

    ApproveCodeRepository approveCodeRepository;
    ApproveCodeBuilder approveCodeBuilder;

    @Autowired
    public ApproveServiceImpl(

            ApproveCodeRepository approveCodeRepository,
            ApproveCodeBuilder approveCodeBuilder) {
        this.approveCodeRepository = approveCodeRepository;
        this.approveCodeBuilder = approveCodeBuilder;
    }

    @Override
    public String create(CreateApproveCodeDto request) {

        return null;
    }
}


