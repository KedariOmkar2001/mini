package org.com.app.spring_boot_backend.mappers;

import org.com.app.spring_boot_backend.entities.works.WorkSubType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WorkSubTypeMapper {

    // Entity → DTO
    @Mapping(source = "workType.workTypeId", target = "workTypeId")
    WorkSubType toDTO(WorkSubType entity);

}
