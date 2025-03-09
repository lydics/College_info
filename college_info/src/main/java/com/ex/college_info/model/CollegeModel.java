package com.ex.college_info.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "college")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollegeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collegeId;

    @Column(nullable = false)
    private String collegeName;

    @Column(nullable = false, unique = true)
    private String code;

    private String address;
    private String city;
    private String state;
    private String country;
    private String phoneNumber;
    private String email;
    private String website;
    private Integer establishedYear;

    @Column(nullable = false)
    private Boolean isActive = true;

    @Column(updatable = false)
    private Timestamp createdAt = Timestamp.from(Instant.now());

    @Column
    private Timestamp updatedAt = Timestamp.from(Instant.now());

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }

    // Constructor without collegeId (For Creating New Entries)
    public CollegeModel(String collegeName, String code, String address, String city, String state, 
                        String country, String phoneNumber, String email, String website, 
                        Integer establishedYear, Boolean isActive) {
        this.collegeName = collegeName;
        this.code = code;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
        this.establishedYear = establishedYear;
        this.isActive = isActive;
        this.createdAt = Timestamp.from(Instant.now());
        this.updatedAt = Timestamp.from(Instant.now());
    }





    // Explicit Getter Methods
    public Long getCollegeId() {
        return collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public Integer getEstablishedYear() {
        return establishedYear;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


}
