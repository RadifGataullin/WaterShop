package ru.profiteam.watershop.domain;

import lombok.Getter;
import lombok.Setter;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.Table;
// чат со службой доставки
@Getter
@Setter
@Table
public class DeliveryServiceMassage extends PersistentObject {

}
