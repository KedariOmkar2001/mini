package org.com.app.spring_boot_backend.controllers.works;

import org.com.app.spring_boot_backend.dtos.works.WorkSubType.WorkSubTypeDTO;
import org.com.app.spring_boot_backend.services.WorkSubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-sub-types")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkSubTypeController {

    private WorkSubTypeService workSubTypeService;
    public WorkSubTypeController(WorkSubTypeService workSubTypeService){
        this.workSubTypeService=workSubTypeService;
    }

    // create
    @PostMapping
    public ResponseEntity<WorkSubTypeDTO> createWorkSubType(@RequestBody WorkSubTypeDTO workSubTypeDTO) {
        try {
            WorkSubTypeDTO created = workSubTypeService.createWorkSubType(workSubTypeDTO);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get
    @GetMapping
    public ResponseEntity<List<WorkSubTypeDTO>> getAllWorkSubTypes() {
        try {
            List<WorkSubTypeDTO> workSubTypes = workSubTypeService.getAllWorkSubTypes();
            if (workSubTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(workSubTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get/{id}
    @GetMapping("/{id}")
    public ResponseEntity<WorkSubTypeDTO> getWorkSubTypeById(@PathVariable("id") Long id) {
        try {
            WorkSubTypeDTO workSubType = workSubTypeService.getWorkSubTypeById(id);
            return new ResponseEntity<>(workSubType, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get/{by-work-type/{id}}
    @GetMapping("/by-work-type/{workTypeId}")
    public ResponseEntity<List<WorkSubTypeDTO>> getWorkSubTypesByWorkTypeId(
            @PathVariable("workTypeId") Integer workTypeId) {
        try {
            List<WorkSubTypeDTO> workSubTypes = workSubTypeService.getWorkSubTypesByWorkTypeId(workTypeId);
            if (workSubTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(workSubTypes, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // put/{id}
    @PutMapping("/{id}")
    public ResponseEntity<WorkSubTypeDTO> updateWorkSubType(
            @PathVariable("id") Long id,
            @RequestBody WorkSubTypeDTO workSubTypeDTO) {
        try {
            WorkSubTypeDTO updated = workSubTypeService.updateWorkSubType(id, workSubTypeDTO);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteWorkSubType(@PathVariable("id") Long id) {
        try {
            workSubTypeService.deleteWorkSubType(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}