package com.idms.idms_backend.controller;

import com.idms.idms_backend.dto.InternRequestDTO;
import com.idms.idms_backend.entity.Intern;
import com.idms.idms_backend.service.InternService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interns")
public class InternController {

    private final InternService internService;
    public InternController(InternService internService) {
        this.internService = internService;
    }

    @PostMapping
    public Intern addIntern(@Valid @RequestBody InternRequestDTO dto) {
        return internService.addIntern(dto);
    }

    @GetMapping
    public List<Intern> getAllInterns() {
        return internService.getAllInterns();
    }

    @DeleteMapping("/{id}")
    public void deleteIntern(@PathVariable Long id) {
        internService.deleteIntern(id);
    }

    @PutMapping("/{id}")
    public Intern updateIntern(@PathVariable Long id,
                               @RequestBody InternRequestDTO dto) {

        return internService.updateIntern(id, dto);
    }

    @GetMapping("/search")
    public List<Intern> searchIntern(@RequestParam String name){
        return internService.searchByName(name);
    }

    @GetMapping("/batch/{batchId}")
    public List<Intern> getInternsByBatch(@PathVariable Long batchId){
        return internService.getInternsByBatch(batchId);
    }

    @GetMapping("/card-type/{type}")
    public List<Intern> getInternsByCardType(@PathVariable String type){
        return internService.getInternsByCardType(type);
    }
}
