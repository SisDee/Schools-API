package com.schools.api.controller;

import com.schools.api.entity.School;
import com.schools.api.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        allowCredentials = "false",
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}
)
@SuppressWarnings("unchecked")
@RestController
public class SchoolController {
    @Autowired
    private SchoolService service;

    @GetMapping("/schools")
    ResponseEntity<List<School>> getSchools(@RequestParam(required = false) String province, @RequestParam(required = false) String postalCode) {


        if (province == null && postalCode == null) {
            return service.getSchools();
         } else if (province!= null && postalCode==null) {
            return service.getSchoolByProvince(province);
        }
        if (postalCode != null && province==null) {
            return service.getSchoolByPostalCode(postalCode);
         } else if (province != null && postalCode != null) {
            return service.getSchools(province,postalCode);
        }
            return service.getSchools();

    }
}

