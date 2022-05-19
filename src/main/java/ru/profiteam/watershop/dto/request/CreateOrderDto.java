package ru.profiteam.watershop.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.enums.OrderStatusType;
import ru.profiteam.watershop.domain.enums.PayMethodType;
import ru.profiteam.watershop.dto.response.UserDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateOrderDto {
    OrderStatusType orderStatusType;
    String data;
    Long userId;
    int productCount;
    double totalPrice;
    PayMethodType payMethodType;
}
