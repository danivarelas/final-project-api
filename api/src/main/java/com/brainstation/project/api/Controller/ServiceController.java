package com.brainstation.project.api.Controller;

import com.brainstation.project.api.Model.Service;
import com.brainstation.project.api.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/v1/service")
@RestController
public class ServiceController {

    private final ServiceService serviceService;
    private HttpServletRequest request;

    @Autowired
    public ServiceController(ServiceService serviceService, HttpServletRequest request) {
        this.serviceService = serviceService;
        this.request = request;
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        //if (JWTProvider.validateToken(request.getHeader("JWT"))) {
        return new ResponseEntity<>(serviceService.selectAllServices() , HttpStatus.OK);
        //} else {
        //    return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        //}
    }

}
