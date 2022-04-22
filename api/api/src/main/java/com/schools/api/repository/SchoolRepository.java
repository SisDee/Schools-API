package com.schools.api.repository;

import com.schools.api.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {

    List<School> findAll();
    List<School> findByProvince(String province);
    List<School> findByPostalCode(String postalCode);
    List<School> findByProvinceAndPostalCode(String province, String postalCode);

}
