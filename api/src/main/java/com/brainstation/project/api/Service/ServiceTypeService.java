package com.brainstation.project.api.Service;

import com.brainstation.project.api.Model.ServiceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceTypeService {

    ServiceType insertServiceType(ServiceType serviceType);

    List<ServiceType> selectAllServiceTypes();

    ServiceType selectServiceTypeById(long id);

    ServiceType updateServiceType(long id, ServiceType serviceType);

    //ServiceType deleteServiceType(long id);
}
