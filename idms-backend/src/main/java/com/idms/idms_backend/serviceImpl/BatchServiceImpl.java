package com.idms.idms_backend.serviceImpl;

import com.idms.idms_backend.dto.BatchRequestDTO;
import com.idms.idms_backend.dto.BatchResponseDTO;
import com.idms.idms_backend.entity.Batch;
import com.idms.idms_backend.repository.BatchRepository;
import com.idms.idms_backend.service.BatchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public BatchResponseDTO createBatch(BatchRequestDTO dto) {

        Batch batch = new Batch();

        batch.setStartDate(dto.getStartDate());

        // Automatically calculate end date (6 months later)
        batch.setEndDate(dto.getStartDate().plusMonths(6));

        Batch savedBatch = batchRepository.save(batch);

        BatchResponseDTO response = new BatchResponseDTO();
        response.setId(savedBatch.getId());
        response.setStartDate(savedBatch.getStartDate());
        response.setEndDate(savedBatch.getEndDate());
        response.setTotalInterns(0);

        return response;
    }

    @Override
    public List<BatchResponseDTO> getAllBatches() {

        return batchRepository.findAll()
                .stream()
                .map(batch -> {
                    BatchResponseDTO dto = new BatchResponseDTO();
                    dto.setId(batch.getId());
                    dto.setStartDate(batch.getStartDate());
                    dto.setEndDate(batch.getEndDate());
                    dto.setTotalInterns(
                            batch.getInterns() == null ? 0 : batch.getInterns().size()
                    );
                    dto.setInterns(batch.getInterns());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BatchResponseDTO getBatchById(Long id) {

        Batch batch = batchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        BatchResponseDTO dto = new BatchResponseDTO();
        dto.setId(batch.getId());
        dto.setStartDate(batch.getStartDate());
        dto.setEndDate(batch.getEndDate());
        dto.setTotalInterns(
                batch.getInterns() == null ? 0 : batch.getInterns().size()
        );

        dto.setInterns(batch.getInterns());

        return dto;
    }

    @Override
    public void deleteBatch(Long id) {
        batchRepository.deleteById(id);
    }
}
