package com.ex.college.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.college.model.collegeModel;

public interface collegeRepository extends JpaRepository<collegeModel, Long> {
    boolean existsByCode(String code);
}

