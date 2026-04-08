package com.idms.idms_backend.dto;

import com.idms.idms_backend.entity.Intern;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class BatchResponseDTO {

    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private int totalInterns;

    private List<Intern> interns;

}
