package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.domain.enums.ProductType;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameLike(String name);

    @Query("SELECT p FROM Product p WHERE (:name is null OR p.name LIKE %:name%)")
    List<Product> getAllFilter(@Param("name") String name);
}
