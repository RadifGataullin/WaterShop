package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
