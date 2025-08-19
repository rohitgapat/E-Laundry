package com.controler;

import com.entity.ServiceType;
import com.Service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service-types")
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService serviceTypeService;

    @PostMapping
    public String addServiceType(@RequestBody ServiceType serviceType) {
        return serviceTypeService.addServiceType(serviceType);
    }

    @GetMapping
    public List<ServiceType> getAllServiceTypes() {
        return serviceTypeService.getAllServiceType();
    }
}
