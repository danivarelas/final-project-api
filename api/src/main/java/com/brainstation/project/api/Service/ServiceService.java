package com.brainstation.project.api.Service;

import com.brainstation.project.api.Model.Service;

import java.util.List;

@org.springframework.stereotype.Service
public interface ServiceService {

    Service insertService(Service service);

    List<Service> selectAllServices();

    Service selectServiceById(long id);

    Service updateService(long id, Service service);

    //Service deleteService(long id);
}
