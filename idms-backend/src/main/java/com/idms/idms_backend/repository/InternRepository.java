package com.idms.idms_backend.repository;

import com.idms.idms_backend.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface InternRepository extends JpaRepository<Intern, Long> {

    List<Intern> findByDateOfJoining(LocalDate dateOfJoining);

    List<Intern> findByNameContainingIgnoreCase(String name);

    List<Intern> findByBatchId(Long batchId);

    List<Intern> findByIdCardType(String idCardType);

}
