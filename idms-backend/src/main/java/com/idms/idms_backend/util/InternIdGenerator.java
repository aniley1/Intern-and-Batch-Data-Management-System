package com.idms.idms_backend.util;

import com.idms.idms_backend.repository.InternRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class InternIdGenerator {

    private final InternRepository internRepository;

    public InternIdGenerator(InternRepository internRepository) {
        this.internRepository = internRepository;
    }

    public String generateInternId(String idCardType, LocalDate joiningDate) {

        String prefix = idCardType.equalsIgnoreCase("Premium") ? "EMP" : "TDA";

        String datePart = joiningDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        int count = internRepository.findByDateOfJoining(joiningDate).size() + 1;

        String sequence = String.format("%03d", count);

        return prefix + datePart + "-" + sequence;
    }
}
