package com.brainstation.project.api.DTO;

import com.brainstation.project.api.Model.ServiceType;

import javax.persistence.*;

@Entity
@Table(name = "service_type")
public class ServiceTypeDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serviceTypeName;

    public ServiceTypeDTO() {
        super();
    }

    public ServiceTypeDTO(ServiceType serviceType) {
        if (serviceType != null) {
            this.serviceTypeName = serviceType.getServiceTypeName();
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
