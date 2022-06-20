package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;
import ru.profiteam.watershop.domain.enums.OrderStatusType;
import ru.profiteam.watershop.domain.enums.PayMethodType;

import javax.persistence.*;

//заказы
@Getter
@Setter
@Entity
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order extends PersistentObject {

    @Column(name = "order_status_type")
    @Enumerated(EnumType.STRING)
    OrderStatusType orderStatusType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "product_count")
    int productCount;

    @Column(name = "total_price")
    double totalPrice;

    @Column(name = "context_type")
    @Enumerated(EnumType.STRING)
    PayMethodType payMethodType;

}
