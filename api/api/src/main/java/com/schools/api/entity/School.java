package com.schools.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "Schools")
@Getter @Setter
public class School {
    @Id
   private String id;
   private String name;
   private String status;
   private String sector;
   private String type;
   private String phase;
   private String specialization;
   @Column (name="examno")
   private String examNo;
   private String  province;
   private String districtMunicipality;
   private String localMunicipality;
   private String suburb;
   private String postalCode;
}
