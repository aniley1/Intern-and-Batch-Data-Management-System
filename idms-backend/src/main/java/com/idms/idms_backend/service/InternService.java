package com.idms.idms_backend.service;

import com.idms.idms_backend.dto.InternRequestDTO;
import com.idms.idms_backend.entity.Intern;

import java.util.List;

public interface InternService {

    Intern addIntern(InternRequestDTO dto);

    List<com.idms.idms_backend.entity.Intern> getAllInterns();

    void deleteIntern(Long id);

    Intern updateIntern(Long id, InternRequestDTO dto);

    List<Intern> searchByName(String name);

    List<Intern> getInternsByBatch(Long batchId);

    List<Intern> getInternsByCardType(String type);

}
