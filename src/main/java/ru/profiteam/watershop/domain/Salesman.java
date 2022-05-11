package ru.profiteam.watershop.domain;

import lombok.Getter;
import lombok.Setter;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.Table;

//продавец
@Getter
@Setter
@Table()
public class Salesman extends PersistentObject {

}
