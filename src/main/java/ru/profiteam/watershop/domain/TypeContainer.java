package ru.profiteam.watershop.domain;

import lombok.Getter;
import lombok.Setter;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.Table;

//тип тары
@Getter
@Setter
@Table()
public class TypeContainer extends PersistentObject {
}
