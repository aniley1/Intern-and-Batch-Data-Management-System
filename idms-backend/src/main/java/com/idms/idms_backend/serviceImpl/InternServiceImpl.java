package com.idms.idms_backend.serviceImpl;

import com.idms.idms_backend.dto.InternRequestDTO;
import com.idms.idms_backend.entity.Batch;
import com.idms.idms_backend.entity.Intern;
import com.idms.idms_backend.repository.BatchRepository;
import com.idms.idms_backend.repository.InternRepository;
import com.idms.idms_backend.service.InternService;
import com.idms.idms_backend.util.InternIdGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternServiceImpl implements InternService {

    private final InternRepository internRepository;
    private final BatchRepository batchRepository;
    private final InternIdGenerator idGenerator;

    public InternServiceImpl(InternRepository internRepository,
                             BatchRepository batchRepository,
                             InternIdGenerator idGenerator) {
        this.internRepository = internRepository;
        this.batchRepository = batchRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public Intern addIntern(InternRequestDTO dto) {

        Batch batch = batchRepository.findById(dto.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        String generatedId = idGenerator.generateInternId(dto.getIdCardType(), dto.getDateOfJoining());

        Intern intern = new Intern();
        intern.setInternId(generatedId);
        intern.setName(dto.getName());
        intern.setEmail(dto.getEmail());
        intern.setMobile(dto.getMobile());
        intern.setIdCardType(dto.getIdCardType());
        intern.setDateOfJoining(dto.getDateOfJoining());
        intern.setBatch(batch);

        return internRepository.save(intern);
    }

    @Override
    public List<Intern> getAllInterns() {
        return internRepository.findAll();
    }

    @Override
    public void deleteIntern(Long id) {
        internRepository.deleteById(id);
    }

    @Override
    public Intern updateIntern(Long id, InternRequestDTO dto) {

        Intern intern = internRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Intern not found"));

        Batch batch = batchRepository.findById(dto.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        intern.setName(dto.getName());
        intern.setEmail(dto.getEmail());
        intern.setMobile(dto.getMobile());
        intern.setIdCardType(dto.getIdCardType());
        intern.setDateOfJoining(dto.getDateOfJoining());
        intern.setBatch(batch);

        return internRepository.save(intern);
    }

    @Override
    public List<Intern> searchByName(String name) {
        return internRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Intern> getInternsByBatch(Long batchId) {
        return internRepository.findByBatchId(batchId);
    }

    @Override
    public List<Intern> getInternsByCardType(String type) {
        return internRepository.findByIdCardType(type);
    }
}