package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.dto.request.CreateApproveCodeDto;
import ru.profiteam.watershop.dto.response.ApproveCodeDto;
import ru.profiteam.watershop.service.ApproveCodeService;
import ru.profiteam.watershop.utils.ErrorSwaggerModel;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("approve_code")
@Tag(name = "Approve_code")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AppruveCodeController {
    ApproveCodeService approveCodeService;

    @Autowired
    public AppruveCodeController(ApproveCodeService approveCodeService) {
        this.approveCodeService = approveCodeService;
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorSwaggerModel.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorSwaggerModel.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorSwaggerModel.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorSwaggerModel.class)))
    })
    @PostMapping("send-code")
    public void sendCode(@RequestBody CreateApproveCodeDto request) {
        approveCodeService.create(request);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorSwaggerModel.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorSwaggerModel.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorSwaggerModel.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorSwaggerModel.class)))
    })
    @PostMapping("approve-code")
    public void approveCode(@RequestBody ApproveCodeDto request) {
        approveCodeService.approve(request);
    }


}
