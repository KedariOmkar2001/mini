package org.com.app.spring_boot_backend.services;

import org.com.app.spring_boot_backend.dtos.works.WorkType.WorkTypeRequestDTO;
import org.com.app.spring_boot_backend.dtos.works.WorkType.WorkTypeResponseDTO;
import org.com.app.spring_boot_backend.entities.works.WorkType;
import org.com.app.spring_boot_backend.repositories.WorkTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkTypeService {

    // dependencies
    private final WorkTypeRepository workTypeRepository;

    // constructor injection
    public WorkTypeService(WorkTypeRepository workTypeRepository) {
        this.workTypeRepository = workTypeRepository;
    }


    // Convert Entity → Response DTO
    private WorkTypeResponseDTO toDTO(WorkType entity) {
        WorkTypeResponseDTO dto = new WorkTypeResponseDTO();
        dto.setWorkTypeId(entity.getWorkTypeId());
        dto.setWorkType(entity.getWorkType());
        dto.setWorkTypeCode(entity.getWorkTypeCode());
        dto.setIsImportant(entity.getIsImportant());
        return dto;
    }

    // Convert Request DTO → Entity
    private WorkType toEntity(WorkTypeRequestDTO dto) {
        WorkType entity = new WorkType();
        entity.setWorkType(dto.getWorkType());
        entity.setWorkTypeCode(dto.getWorkTypeCode());
        entity.setIsImportant(dto.getIsImportant());
        return entity;
    }


    // crud methods

    public List<WorkTypeResponseDTO> findAll() {
        return workTypeRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public WorkTypeResponseDTO findById(int id) {
        return workTypeRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("WorkType not found"));
    }

    public WorkTypeResponseDTO save(WorkTypeRequestDTO dto) {
        WorkType entity = toEntity(dto);
        WorkType saved = workTypeRepository.save(entity);
        return toDTO(saved);
    }

    public WorkTypeResponseDTO update(int id, WorkTypeRequestDTO dto) {
        WorkType entity = workTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkType not found"));

        entity.setWorkType(dto.getWorkType());
        entity.setWorkTypeCode(dto.getWorkTypeCode());
        entity.setIsImportant(dto.getIsImportant());

        WorkType updated = workTypeRepository.save(entity);
        return toDTO(updated);
    }

    public void delete(int id) {
        if (!workTypeRepository.existsById(id)) {
            throw new RuntimeException("WorkType not found");
        }
        workTypeRepository.deleteById(id);
    }
}
