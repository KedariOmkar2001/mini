package org.com.app.spring_boot_backend.services;

import org.com.app.spring_boot_backend.dtos.works.WorkSubType.WorkSubTypeDTO;
import org.com.app.spring_boot_backend.dtos.works.WorkType.WorkTypeDTO;
import org.com.app.spring_boot_backend.entities.works.WorkSubType;
import org.com.app.spring_boot_backend.entities.works.WorkType;
import org.com.app.spring_boot_backend.repositories.WorkSubTypeRepository;
import org.com.app.spring_boot_backend.repositories.WorkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WorkSubTypeService {

    @Autowired
    private WorkSubTypeRepository workSubTypeRepository;

    @Autowired
    private WorkTypeRepository workTypeRepository;

    /**
     * Create a new WorkSubType
     * POST /api/work-sub-types
     */
    public WorkSubTypeDTO createWorkSubType(WorkSubTypeDTO dto) {
        // Validate that the WorkType exists
        WorkType workType = workTypeRepository.findById(dto.getWorkTypeId())
                .orElseThrow(() -> new RuntimeException("WorkType not found with id: " + dto.getWorkTypeId()));

        // Create new WorkSubType entity
        WorkSubType workSubType = new WorkSubType();
        workSubType.setWorkSubType(dto.getWorkSubType());
        workSubType.setWorkType(workType);

        // Save and return
        WorkSubType savedWorkSubType = workSubTypeRepository.save(workSubType);
        return convertToDTO(savedWorkSubType);
    }

    /**
     * Get all WorkSubTypes
     * GET /api/work-sub-types
     */
    public List<WorkSubTypeDTO> getAllWorkSubTypes() {
        return workSubTypeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get WorkSubType by ID
     * GET /api/work-sub-types/{id}
     */
    public WorkSubTypeDTO getWorkSubTypeById(Long id) {
        WorkSubType workSubType = workSubTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkSubType not found with id: " + id));
        return convertToDTO(workSubType);
    }

    /**
     * Get all WorkSubTypes by parent WorkType ID
     * GET /api/work-sub-types/by-work-type/{workTypeId}
     */
    public List<WorkSubTypeDTO> getWorkSubTypesByWorkTypeId(Integer workTypeId) {
        // Validate that the WorkType exists
        workTypeRepository.findById(workTypeId)
                .orElseThrow(() -> new RuntimeException("WorkType not found with id: " + workTypeId));

        // Filter WorkSubTypes by WorkType ID
        return workSubTypeRepository.findAll()
                .stream()
                .filter(wst -> wst.getWorkType().getWorkTypeId() == workTypeId)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Update an existing WorkSubType
     * PUT /api/work-sub-types/{id}
     */
    public WorkSubTypeDTO updateWorkSubType(Long id, WorkSubTypeDTO dto) {
        // Find existing WorkSubType
        WorkSubType workSubType = workSubTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkSubType not found with id: " + id));

        // Validate that the new WorkType exists
        WorkType workType = workTypeRepository.findById(dto.getWorkTypeId())
                .orElseThrow(() -> new RuntimeException("WorkType not found with id: " + dto.getWorkTypeId()));

        // Update fields
        workSubType.setWorkSubType(dto.getWorkSubType());
        workSubType.setWorkType(workType);

        // Save and return
        WorkSubType updatedWorkSubType = workSubTypeRepository.save(workSubType);
        return convertToDTO(updatedWorkSubType);
    }

    /**
     * Delete a WorkSubType by ID
     * DELETE /api/work-sub-types/{id}
     */
    public void deleteWorkSubType(Long id) {
        if (!workSubTypeRepository.existsById(id)) {
            throw new RuntimeException("WorkSubType not found with id: " + id);
        }
        workSubTypeRepository.deleteById(id);
    }

    /**
     * Helper method to convert Entity to DTO
     */
    private WorkSubTypeDTO convertToDTO(WorkSubType workSubType) {
        WorkType workTypeEntity = workSubType.getWorkType();
        WorkTypeDTO workTypeDTO = new WorkTypeDTO(
                workTypeEntity.getWorkTypeId(),
                workTypeEntity.getWorkType(),
                workTypeEntity.getWorkTypeCode(),
                workTypeEntity.getIsImportant()
        );
        return new WorkSubTypeDTO(
                workSubType.getWorkSubTypeId(),
                workSubType.getWorkSubType(),
                workTypeEntity.getWorkTypeId(),
                workTypeDTO
        );
    }
}