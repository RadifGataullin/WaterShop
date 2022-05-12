package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.SaleOrganisation;

@Repository
public interface SaleOrganisationRepository extends JpaRepository<SaleOrganisation, Long> {
}
