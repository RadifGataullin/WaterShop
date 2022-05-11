package ru.profiteam.watershop.domain;

import lombok.Getter;
import lombok.Setter;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
//слиент

@Getter
@Setter
@Table()
@Entity
public class Client extends PersistentObject {
     private String name ;


}
