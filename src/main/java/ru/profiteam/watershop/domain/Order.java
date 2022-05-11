package ru.profiteam.watershop.domain;

import lombok.Getter;
import lombok.Setter;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.Table;

//заказы
@Getter
@Setter
@Table()
public class Order extends PersistentObject {
}
