package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.ApproveCode;
import ru.profiteam.watershop.dto.request.CreateApproveCodeDto;
import ru.profiteam.watershop.dto.response.ApproveCodeDto;

public interface ApproveCodeBuilder {
    ApproveCode build(CreateApproveCodeDto approveCode);

}
