package ru.profiteam.watershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.profiteam.watershop.domain.enums.OrderStatusType;
import ru.profiteam.watershop.domain.enums.PayMethodType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    Long id;
    OrderStatusType orderStatusType;
    String data;
    UserDto user;
    int productCount;
    double totalPrice;
    PayMethodType payMethodType;
}
