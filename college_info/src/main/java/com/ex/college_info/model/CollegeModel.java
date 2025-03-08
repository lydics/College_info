package com.ex.college_info.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime createdAt = LocalDateTime.now();

    public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
