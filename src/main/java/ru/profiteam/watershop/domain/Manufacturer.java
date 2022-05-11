package ru.profiteam.watershop.domain;

import lombok.Getter;
import lombok.Setter;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.Table;

//производитель
@Getter
@Setter
@Table()
public class Manufacturer extends PersistentObject {
}
