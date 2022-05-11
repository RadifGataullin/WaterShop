package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
