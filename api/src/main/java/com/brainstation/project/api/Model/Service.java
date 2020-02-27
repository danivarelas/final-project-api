package com.brainstation.project.api.Model;

import com.brainstation.project.api.DTO.ServiceDTO;

public class Service {

    private long id;
    private String serviceName;
    private long serviceTypeId;

    public Service() {
        super();
    }

    public Service(ServiceDTO serviceDTO) {
        if (serviceDTO != null) {
            this.id = serviceDTO.getId();
            this.serviceName = serviceDTO.getServiceName();
            this.serviceTypeId = serviceDTO.getServiceTypeId();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }
}
