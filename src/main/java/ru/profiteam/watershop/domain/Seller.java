package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.*;

//продавец
@Getter
@Setter
@Entity
@Table(name = "seller")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seller extends PersistentObject {

    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "inn")
    String inn;

    @Column(name = "bik")
    String bik;

    @Column(name = "description")
    String description;

}
