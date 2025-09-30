package org.com.app.spring_boot_backend.services;

import org.com.app.spring_boot_backend.dtos.works.WorkType.WorkTypeDTO;
import org.com.app.spring_boot_backend.entities.works.WorkType;
import org.com.app.spring_boot_backend.repositories.WorkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WorkTypeService {

    @Autowired
    private WorkTypeRepository workTypeRepository;

    // Create
    public WorkTypeDTO createWorkType(WorkTypeDTO dto) {
        WorkType workType = new WorkType();
        workType.setWorkType(dto.getWorkType());
        workType.setWorkTypeCode(dto.getWorkTypeCode());
        workType.setIsImportant(dto.getIsImportant());

        WorkType savedWorkType = workTypeRepository.save(workType);
        return convertToDTO(savedWorkType);
    }

    // Read All
    public List<WorkTypeDTO> getAllWorkTypes() {
        return workTypeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Read by ID
    public WorkTypeDTO getWorkTypeById(Integer id) {
        WorkType workType = workTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkType not found with id: " + id));
        return convertToDTO(workType);
    }

    // Update
    public WorkTypeDTO updateWorkType(Integer id, WorkTypeDTO dto) {
        WorkType workType = workTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkType not found with id: " + id));

        workType.setWorkType(dto.getWorkType());
        workType.setWorkTypeCode(dto.getWorkTypeCode());
        workType.setIsImportant(dto.getIsImportant());

        WorkType updatedWorkType = workTypeRepository.save(workType);
        return convertToDTO(updatedWorkType);
    }

    // Delete
    public void deleteWorkType(Integer id) {
        if (!workTypeRepository.existsById(id)) {
            throw new RuntimeException("WorkType not found with id: " + id);
        }
        workTypeRepository.deleteById(id);
    }

    // Convert Entity to DTO
    private WorkTypeDTO convertToDTO(WorkType workType) {
        return new WorkTypeDTO(
                workType.getWorkTypeId(),
                workType.getWorkType(),
                workType.getWorkTypeCode(),
                workType.getIsImportant()
        );
    }
}