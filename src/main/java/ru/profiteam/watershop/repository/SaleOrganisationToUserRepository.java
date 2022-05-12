package ru.profiteam.watershop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.SaleOrganisationToUser;

@Repository
public interface SaleOrganisationToUserRepository extends JpaRepository<SaleOrganisationToUser, Long> {

}
