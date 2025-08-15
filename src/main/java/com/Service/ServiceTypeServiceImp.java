package com.Service;

import com.entity.ServiceType;
import com.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImp implements ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepo;

    @Override
    public String addServiceType(ServiceType serviceType) {
        serviceTypeRepo.save(serviceType);
        return "Service type added successfully";
    }

    @Override
    public List<ServiceType> getAllServiceType() {
        return serviceTypeRepo.findAll();
    }
}
