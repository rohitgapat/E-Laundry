package com.Service;

import java.util.List;

import com.entity.ServiceType;

public interface ServiceTypeService {

	public String addServiceType(ServiceType serviceType);
	public List<ServiceType> getAllServiceType();
	}
