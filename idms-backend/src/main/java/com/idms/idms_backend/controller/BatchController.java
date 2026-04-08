package com.idms.idms_backend.controller;

import com.idms.idms_backend.dto.BatchRequestDTO;
import com.idms.idms_backend.dto.BatchResponseDTO;
import com.idms.idms_backend.service.BatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping
    public BatchResponseDTO createBatch(@RequestBody BatchRequestDTO dto) {
        return batchService.createBatch(dto);
    }

    @GetMapping
    public List<BatchResponseDTO> getAllBatches() {
        return batchService.getAllBatches();
    }

    @GetMapping("/{id}")
    public BatchResponseDTO getBatchById(@PathVariable Long id) {
        return batchService.getBatchById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBatch(@PathVariable Long id) {
        batchService.deleteBatch(id);
    }
}
