package ru.profiteam.watershop.domain;
import lombok.Getter;
import lombok.Setter;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.Table;
//адрес клиента
@Table()
@Getter
@Setter
public class ClientAddress extends PersistentObject {

}
