package com.schools.api.service;

import com.schools.api.entity.School;
import com.schools.api.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.invoke.SwitchPoint;
import java.util.List;
import java.util.Locale;

/**
 * TODO:
 * Better method naming[overloading]
 * Error handling on downstream:
 * Exception for database,
 * Handling parameters
 * Pagination (scalability and quick response)
 * Testing and code coverage
 */

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository repository;

    public ResponseEntity<List<School>> getSchools(){
        try {
            throw new Exception("Deliberate");
//            return new ResponseEntity<List<School>>(repository.findAll(), HttpStatus.OK);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Server is unavailable");
        }
    }
    public ResponseEntity<List<School>> getSchoolByProvince(String province){
        try {
        return new ResponseEntity<List<School>>(repository.findByProvince(province), HttpStatus.OK);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Server is unavailable");
        }
    }

    public ResponseEntity<List<School>> getSchoolByPostalCode(String postalCode){
        try {
        return new ResponseEntity<List<School>>(repository.findByPostalCode(postalCode), HttpStatus.OK);
    }catch (Exception exception){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"DOES NOT EXIST IN DATABASE");
    }

    }public ResponseEntity<List<School>> getSchools(String province,String postalCode){
        try {
        return new ResponseEntity<List<School>>(repository.findByProvinceAndPostalCode(province,postalCode), HttpStatus.OK);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"DOES NOT EXIST IN DATABASE");
        }
    }


}
