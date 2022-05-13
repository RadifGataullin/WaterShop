package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
