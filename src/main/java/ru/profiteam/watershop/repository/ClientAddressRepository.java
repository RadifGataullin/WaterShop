package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.ClientAddress;
import ru.profiteam.watershop.domain.base.PersistentObject;

@Repository
public interface ClientAddressRepository extends JpaRepository<ClientAddress, Long> {
}
