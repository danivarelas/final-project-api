package com.brainstation.project.api.DAO;

import com.brainstation.project.api.DTO.ServiceTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ServiceTypeDAO extends JpaRepository<ServiceTypeDTO, Long> {

    @Query("SELECT st FROM ServiceTypeDTO st ORDER BY st.id ASC")
    List<ServiceTypeDTO> findAll();
}
