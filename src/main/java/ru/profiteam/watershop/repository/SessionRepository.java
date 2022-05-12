package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.profiteam.watershop.domain.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
