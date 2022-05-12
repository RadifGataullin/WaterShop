package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "sale_organisation_to_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaleOrganisationToUser extends PersistentObject {

    @ManyToOne
    @JoinColumn(name = "sale_organisation_id")
    SaleOrganisation saleOrganisation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
