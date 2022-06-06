package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.ApproveCodeBuilder;
import ru.profiteam.watershop.domain.ApproveCode;
import ru.profiteam.watershop.domain.Country;
import ru.profiteam.watershop.dto.request.CreateApproveCodeDto;
import ru.profiteam.watershop.dto.response.ApproveCodeDto;
import ru.profiteam.watershop.dto.response.CountryDto;
import ru.profiteam.watershop.repository.ApproveCodeRepository;
import ru.profiteam.watershop.service.ApproveCodeService;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApproveCodeServiceImpl implements ApproveCodeService {

    ApproveCodeRepository approveCodeRepository;
    ApproveCodeBuilder approveCodeBuilder;

    @Autowired
    public ApproveCodeServiceImpl(

            ApproveCodeRepository approveCodeRepository,
            ApproveCodeBuilder approveCodeBuilder) {
        this.approveCodeRepository = approveCodeRepository;
        this.approveCodeBuilder = approveCodeBuilder;
    }

    @Override
    public void create(CreateApproveCodeDto request) {
        ApproveCode approveCode = approveCodeBuilder.build(request);
        approveCodeRepository.save(approveCode);

    }

    @Override
    public List<ApproveCodeDto> getAll() {
        List<ApproveCode> approveCodeList = approveCodeRepository.findAll();
        List<ApproveCodeDto> approveCodeDtoList = new ArrayList<>();
        for (ApproveCode item : approveCodeList) {
            approveCodeDtoList.add(approveCodeBuilder.build(item));
        }
        return approveCodeDtoList;

    }
}


