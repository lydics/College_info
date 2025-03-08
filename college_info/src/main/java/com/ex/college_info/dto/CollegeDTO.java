package com.ex.college_info.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollegeDTO {

    @NotBlank(message = "College name is required")
    @Size(max = 255, message = "College name should not exceed 255 characters")
    private String collegeName;

    @NotBlank(message = "Code is required")
    @Pattern(regexp = "^[A-Z0-9]+$", message = "Code must be uppercase letters or numbers only")
    private String code;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Country is required")
    private String country;

    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number")
    private String phoneNumber;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Website URL is required")
    @Pattern(regexp = "^(http|https)://.*$", message = "Website must be a valid URL")
    private String website;

    @Min(value = 1800, message = "Established year must be after 1800")
    @Max(value = 2025, message = "Established year must not exceed the current year")
    private Integer establishedYear;

    private Boolean isActive;

    // Explicit Getter Methods
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
}
