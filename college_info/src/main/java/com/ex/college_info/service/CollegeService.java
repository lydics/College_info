package com.ex.college_info.service;

import com.ex.college_info.dto.CollegeDTO;
import com.ex.college_info.model.CollegeModel;
import com.ex.college_info.repo.CollegeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {

    private final CollegeRepository collegeRepository;

    public CollegeService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    public CollegeModel addCollege(CollegeDTO collegeDTO) {
        if (collegeRepository.existsByCode(collegeDTO.getCode())) {
            throw new RuntimeException("College code already exists");
        }

        // Creating a new CollegeModel instance with provided details
        CollegeModel college = new CollegeModel(
                collegeDTO.getCollegeName(),
                collegeDTO.getCode(),
                collegeDTO.getAddress(),
                collegeDTO.getCity(),
                collegeDTO.getState(),
                collegeDTO.getCountry(),
                collegeDTO.getPhoneNumber(),
                collegeDTO.getEmail(),
                collegeDTO.getWebsite(),
                collegeDTO.getEstablishedYear(),
                collegeDTO.getIsActive()
        );

        // Explicitly setting createdAt and updatedAt timestamps
        college.setCreatedAt(LocalDateTime.now());
        college.setUpdatedAt(LocalDateTime.now());

        // Saving the college entity to the database
        CollegeModel savedCollege = collegeRepository.save(college);

        return savedCollege;  // Returning the saved object with generated collegeId
    }

    public List<CollegeModel> getAllColleges() {
        return collegeRepository.findAll();
    }

    public Optional<CollegeModel> getCollegeById(Long id) {
        return collegeRepository.findById(id);
    }

    public void deleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }
}
