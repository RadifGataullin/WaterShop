package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.ApproveCode;
@Repository
public interface ApproveCodeRepository extends JpaRepository <ApproveCode,Long> {



    }

