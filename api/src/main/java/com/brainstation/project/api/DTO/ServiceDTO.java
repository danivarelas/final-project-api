package com.brainstation.project.api.DTO;

import com.brainstation.project.api.Model.Service;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class ServiceDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serviceName;
    private Long serviceTypeId;

    public ServiceDTO() {
        super();
    }

    public ServiceDTO(Service service) {
        if (service != null) {
            this.serviceName = service.getServiceName();
            this.serviceTypeId = service.getServiceTypeId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }
}
