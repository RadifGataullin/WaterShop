package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;
import ru.profiteam.watershop.domain.enums.UserType;

import javax.persistence.*;
//слиент

@Getter
@Setter
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends PersistentObject {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    UserType type;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "login")
    String login;

    @Column(name = "password")
    String password;

    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    int phoneNumber;

    @ManyToOne
    @JoinColumn(name = "city_id")
    City city;

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;



}
