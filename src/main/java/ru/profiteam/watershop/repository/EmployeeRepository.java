package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
