package org.com.app.spring_boot_backend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/works")
public class WorkController {


    @GetMapping()
    public String GetWorks(){
        return "It's Works";
    }

}
