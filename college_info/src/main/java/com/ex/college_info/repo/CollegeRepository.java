package com.ex.college_info.repo;
import com.ex.college_info.model.CollegeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<CollegeModel, Long> {
    boolean existsByCode(String code);
}

