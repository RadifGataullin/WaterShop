package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table ( name = " approve_code")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApproveCode  extends PersistentObject {

    @Column(name = "number")
    String number;

    @Column(name = "code")
    int code;

    @Column( name = "is_activated")
    boolean isActivated;

}
