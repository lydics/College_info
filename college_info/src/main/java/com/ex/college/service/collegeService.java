package com.ex.college.service;

import com.ex.college.model.collegeModel;
import com.ex.college.repo.collegeRepository;

import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.Instant;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class collegeService {

    private final collegeRepository collegeRepository;

    public collegeService(collegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    public collegeModel addCollege(collegeModel college) {
        validateCollegeDetails(college); // Validate input data

        if (collegeRepository.existsByCode(college.getCode())) {
            throw new RuntimeException("College code already exists");
        }

     // Set timestamps
        college.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        college.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return collegeRepository.save(college);
    }

    public List<collegeModel> getAllColleges() {
        return collegeRepository.findAll();
    }

    public Optional<collegeModel> getCollegeById(Long id) {
        return collegeRepository.findById(id);
    }

    public void deleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }

    private void validateCollegeDetails(collegeModel college) {
        if (college.getCollegeName() == null || college.getCollegeName().isBlank()) {
            throw new IllegalArgumentException("College name is required");
        }

        if (college.getCode() == null || !college.getCode().matches("^[A-Z0-9]+$")) {
            throw new IllegalArgumentException("Code must contain only uppercase letters and numbers");
        }

        if (college.getAddress() == null || college.getAddress().isBlank()) {
            throw new IllegalArgumentException("Address is required");
        }

        if (college.getCity() == null || college.getCity().isBlank()) {
            throw new IllegalArgumentException("City is required");
        }

        if (college.getState() == null || college.getState().isBlank()) {
            throw new IllegalArgumentException("State is required");
        }

        if (college.getCountry() == null || college.getCountry().isBlank()) {
            throw new IllegalArgumentException("Country is required");
        }

        if (college.getPhoneNumber() == null || !Pattern.matches("^[0-9]{10}$", college.getPhoneNumber())) {
            throw new IllegalArgumentException("Invalid phone number format. Must be 10 digits.");
        }

        if (college.getEmail() == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", college.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (college.getWebsite() == null || !college.getWebsite().matches("^(http|https)://.*$")) {
            throw new IllegalArgumentException("Website must be a valid URL (http/https)");
        }

        if (college.getEstablishedYear() == null || college.getEstablishedYear() < 1800 || college.getEstablishedYear() > 2025) {
            throw new IllegalArgumentException("Established year must be between 1800 and 2025");
        }
    }
}
