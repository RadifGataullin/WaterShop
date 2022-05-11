package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Salesman;

@Repository
public interface SalesmanRepository extends JpaRepository<Salesman, Long> {
}
