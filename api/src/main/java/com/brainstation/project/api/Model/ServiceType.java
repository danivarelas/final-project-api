package com.brainstation.project.api.Model;

import com.brainstation.project.api.DTO.ServiceTypeDTO;

public class ServiceType {

    private Long id;
    private String serviceTypeName;

    public ServiceType() {
        super();
    }

    public ServiceType(ServiceTypeDTO serviceTypeDTO) {
        if (serviceTypeDTO != null) {
            this.id = serviceTypeDTO.getId();
            this.serviceTypeName = serviceTypeDTO.getServiceTypeName();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
