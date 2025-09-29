package org.com.app.spring_boot_backend.services;


import org.com.app.spring_boot_backend.dtos.works.WorkSubType.WorkSubTypeReadDto;
import org.com.app.spring_boot_backend.dtos.works.WorkSubType.WorkSubTypeSaveDto;
import org.com.app.spring_boot_backend.entities.works.WorkSubType;
import org.com.app.spring_boot_backend.repositories.WorkSubTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkSubTypeService {

    private WorkSubTypeRepository workSubTypeRepository;

    // constructor injection
    public WorkSubTypeService(WorkSubTypeRepository workSubTypeRepository) {
        this.workSubTypeRepository = workSubTypeRepository;
    }

    // methods

    // Convert Entity -> Response DTO
    private WorkSubTypeReadDto toDto(WorkSubType entity){
        WorkSubTypeReadDto dto = new WorkSubTypeReadDto();
        dto.setWorkSubType(entity.getWorkSubType());
        return dto;
    }

    private WorkSubType toEntity(WorkSubTypeSaveDto dto){
        WorkSubType entity = new WorkSubType();
//        entity.setWorkType(dto.getWorkSubType());
        entity.setWorkSubType(dto.getWorkSubTypeName());
        return entity;
    }


    public List<WorkSubTypeReadDto> getWorkTypeResponseDTO() {
        return workSubTypeRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }



}
