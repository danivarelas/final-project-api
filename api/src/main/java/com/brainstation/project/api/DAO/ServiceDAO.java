package com.brainstation.project.api.DAO;

import com.brainstation.project.api.DTO.ServiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ServiceDAO extends JpaRepository<ServiceDTO, Long> {
}
