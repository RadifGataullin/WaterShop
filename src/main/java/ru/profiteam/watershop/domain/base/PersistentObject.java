package ru.profiteam.watershop.domain.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PersistentObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


}
