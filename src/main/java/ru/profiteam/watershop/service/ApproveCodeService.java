package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateApproveCodeDto;

public interface ApproveCodeService {
    String create(CreateApproveCodeDto request);
}
