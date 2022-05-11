package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.AvailableCitiesToOrder;

@Repository
public interface AvailableCitesToOrderRepository extends JpaRepository<AvailableCitiesToOrder, Long> {
}
