package ru.profiteam.admin.data.service;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.profiteam.admin.data.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);
}