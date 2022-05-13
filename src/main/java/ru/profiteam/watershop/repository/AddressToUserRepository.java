package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.profiteam.watershop.domain.AddressToUser;

public interface AddressToUserRepository extends JpaRepository<AddressToUser, Long> {
}