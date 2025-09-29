package org.com.app.spring_boot_backend.controllers.works;

import org.com.app.spring_boot_backend.dtos.works.WorkType.WorkTypeRequestDTO;
import org.com.app.spring_boot_backend.dtos.works.WorkType.WorkTypeResponseDTO;
import org.com.app.spring_boot_backend.services.WorkTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/worktypes")
public class WorkTypeController {

    private final WorkTypeService workTypeService;

    public WorkTypeController(WorkTypeService workTypeService) {
        this.workTypeService = workTypeService;
    }

    @GetMapping
    public List<WorkTypeResponseDTO> getAll() {
        return workTypeService.findAll();
    }

    @GetMapping("/{id}")
    public WorkTypeResponseDTO getById(@PathVariable int id) {
        return workTypeService.findById(id);
    }

    @PostMapping
    public WorkTypeResponseDTO create(@RequestBody WorkTypeRequestDTO dto) {
        return workTypeService.save(dto);
    }

    @PutMapping("/{id}")
    public WorkTypeResponseDTO update(@PathVariable int id, @RequestBody WorkTypeRequestDTO dto) {
        return workTypeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        workTypeService.delete(id);
        return "WorkType with id " + id + " deleted successfully.";
    }
}
