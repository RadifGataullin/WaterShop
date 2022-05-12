package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
