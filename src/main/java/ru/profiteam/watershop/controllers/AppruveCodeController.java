package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import ru.profiteam.watershop.dto.request.CreateApproveCodeDto;
import ru.profiteam.watershop.dto.response.ApproveCodeDto;
import ru.profiteam.watershop.service.ApproveCodeService;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("approve_code")
@Tag(name = "Approve_code")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AppruveCodeController {
    ApproveCodeService approveCodeService;

    @Autowired
    public AppruveCodeController(ApproveCodeService approveCodeService) {
        this.approveCodeService = approveCodeService;}

    @PostMapping("send-code")
    public void sendCode (@RequestBody CreateApproveCodeDto request) {
        approveCodeService.create(request);
    }


    @PostMapping("approve-code")
    public void approveCode (@RequestBody ApproveCodeDto request) {
        approveCodeService.approve(request);
    }


}
