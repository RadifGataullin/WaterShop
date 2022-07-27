package ru.profiteam.admin.data.service;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.profiteam.admin.data.entity.SamplePerson;

public interface SamplePersonRepository extends JpaRepository<SamplePerson, UUID> {

}