package com.brainstation.project.api.Service;

import com.brainstation.project.api.DAO.ServiceTypeDAO;
import com.brainstation.project.api.DTO.ServiceTypeDTO;
import com.brainstation.project.api.Model.ServiceType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ServiceTypeServiceImp")
public class ServiceTypeServiceImp implements ServiceTypeService{

    private final ServiceTypeDAO serviceTypeDAO;

    public ServiceTypeServiceImp(ServiceTypeDAO serviceTypeDAO) {
        this.serviceTypeDAO = serviceTypeDAO;
    }

    @Override
    public ServiceType insertServiceType(ServiceType serviceType) {
        ServiceTypeDTO serviceTypeDTO = serviceTypeDAO.save(new ServiceTypeDTO(serviceType));
        return new ServiceType(serviceTypeDTO);
    }

    @Override
    public List<ServiceType> selectAllServiceTypes() {
        List<ServiceTypeDTO> serviceTypeDTOS = serviceTypeDAO.findAll();
        List<ServiceType> serviceTypes = new ArrayList<>();
        serviceTypeDTOS.forEach(serviceType -> {
            serviceTypes.add(new ServiceType(serviceType));
        });
        return serviceTypes;
    }

    @Override
    public ServiceType selectServiceTypeById(long id) {
        ServiceTypeDTO serviceTypeDTO = serviceTypeDAO.findById(id).get();
        return new ServiceType(serviceTypeDTO);
    }

    @Override
    public ServiceType updateServiceType(long id, ServiceType serviceType) {
        return null;
    }
}
