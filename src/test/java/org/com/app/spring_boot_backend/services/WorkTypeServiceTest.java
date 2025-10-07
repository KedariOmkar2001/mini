package org.com.app.spring_boot_backend.services;


import org.com.app.spring_boot_backend.dtos.works.WorkType.WorkTypeDTO;
import org.com.app.spring_boot_backend.entities.works.WorkType;
import org.com.app.spring_boot_backend.repositories.WorkTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
public class WorkTypeServiceTest {

    @Mock
    private WorkTypeRepository workTypeRepository;

    @InjectMocks
    private WorkTypeService workTypeService;


    @Test
    void shouldReturnWorkTypeWhenExists(){
        WorkTypeDTO workTypeDTO = new WorkTypeDTO();
    }

}
