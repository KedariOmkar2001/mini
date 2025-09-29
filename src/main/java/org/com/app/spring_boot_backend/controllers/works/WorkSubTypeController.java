package org.com.app.spring_boot_backend.controllers.works;
import org.com.app.spring_boot_backend.dtos.works.WorkSubType.WorkSubTypeReadDto;
import org.com.app.spring_boot_backend.services.WorkSubTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/worksubtypes")
public class WorkSubTypeController {

    // injection
    private WorkSubTypeService workSubTypeService;

    public WorkSubTypeController(WorkSubTypeService workSubTypeService) {
        this.workSubTypeService = workSubTypeService;
    }


    @GetMapping("/test")
    public String Message(){
        return "Work Sub Type API";
    }

    @GetMapping
    public List<WorkSubTypeReadDto> getWorkSubTypeResponseDTO(){
        return this.workSubTypeService.getWorkTypeResponseDTO();
    }

}
