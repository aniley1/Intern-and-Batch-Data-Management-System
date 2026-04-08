package com.idms.idms_backend.service;

import com.idms.idms_backend.dto.BatchRequestDTO;
import com.idms.idms_backend.dto.BatchResponseDTO;

import java.util.List;

public interface BatchService {

    BatchResponseDTO createBatch(BatchRequestDTO dto);

    List<BatchResponseDTO> getAllBatches();

    BatchResponseDTO getBatchById(Long id);

    void deleteBatch(Long id);

}
