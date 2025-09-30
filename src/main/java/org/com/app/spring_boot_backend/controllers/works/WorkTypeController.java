package org.com.app.spring_boot_backend.controllers.works;

import org.com.app.spring_boot_backend.dtos.works.WorkType.WorkTypeDTO;
import org.com.app.spring_boot_backend.services.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-types")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkTypeController {

    @Autowired
    private WorkTypeService workTypeService;

    // Create
    @PostMapping
    public ResponseEntity<WorkTypeDTO> createWorkType(@RequestBody WorkTypeDTO workTypeDTO) {
        try {
            WorkTypeDTO created = workTypeService.createWorkType(workTypeDTO);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<WorkTypeDTO>> getAllWorkTypes() {
        try {
            List<WorkTypeDTO> workTypes = workTypeService.getAllWorkTypes();
            if (workTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(workTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkTypeDTO> getWorkTypeById(@PathVariable("id") Integer id) {
        try {
            WorkTypeDTO workType = workTypeService.getWorkTypeById(id);
            return new ResponseEntity<>(workType, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<WorkTypeDTO> updateWorkType(
            @PathVariable("id") Integer id,
            @RequestBody WorkTypeDTO workTypeDTO) {
        try {
            WorkTypeDTO updated = workTypeService.updateWorkType(id, workTypeDTO);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteWorkType(@PathVariable("id") Integer id) {
        try {
            workTypeService.deleteWorkType(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}