package ru.profiteam.watershop.domain;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "grocery_basket")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroceryBasket extends PersistentObject {
    @Column(name = "name")
    String name;

    @Column(name = "userid")
    String userId;

    @Column(name = "orders")
    String orders;
}
