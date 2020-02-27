package com.brainstation.project.api.Controller;

import com.brainstation.project.api.Model.ServiceType;
import com.brainstation.project.api.Service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/v1/serviceType")
@RestController
public class ServiceTypeController {

    private final ServiceTypeService serviceTypeService;
    private HttpServletRequest request;

    @Autowired
    public ServiceTypeController(ServiceTypeService serviceTypeService, HttpServletRequest request) {
        this.serviceTypeService = serviceTypeService;
        this.request = request;
    }

    @GetMapping
    public ResponseEntity<List<ServiceType>> getAllServiceTypes() {
        //if (JWTProvider.validateToken(request.getHeader("JWT"))) {
        return new ResponseEntity<>(serviceTypeService.selectAllServiceTypes() , HttpStatus.OK);
        //} else {
        //    return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        //}
    }

}
