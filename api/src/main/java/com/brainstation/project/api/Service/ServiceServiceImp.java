package com.brainstation.project.api.Service;

import com.brainstation.project.api.DAO.ServiceDAO;
import com.brainstation.project.api.DTO.ServiceDTO;
import com.brainstation.project.api.Model.Service;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service("ServiceServiceImp")
public class ServiceServiceImp implements ServiceService{

    private final ServiceDAO serviceDAO;

    public ServiceServiceImp(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @Override
    public Service insertService(Service service) {
        ServiceDTO serviceDTO = serviceDAO.save(new ServiceDTO(service));
        return new Service(serviceDTO);
    }

    @Override
    public List<Service> selectAllServices() {
        List<ServiceDTO> serviceDTOS = serviceDAO.findAll();
        List<Service> services = new ArrayList<>();
        serviceDTOS.forEach(service -> {
            services.add(new Service(service));
        });
        return services;
    }

    @Override
    public Service selectServiceById(long id) {
        ServiceDTO serviceDTO = serviceDAO.findById(id).get();
        return new Service(serviceDTO);
    }

    @Override
    public Service updateService(long id, Service service) {
        return null;
    }
}
