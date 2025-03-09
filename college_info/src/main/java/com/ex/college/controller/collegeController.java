package com.ex.college.controller;

import com.ex.college.model.collegeModel;
import com.ex.college.service.collegeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/colleges")
public class collegeController {

    private final collegeService collegeService;

    public collegeController(collegeService collegeService) {
        this.collegeService = collegeService;
    }

    @PostMapping
    public ResponseEntity<collegeModel> createCollege(@RequestBody collegeModel collegeModel) {
        return ResponseEntity.ok(collegeService.addCollege(collegeModel));
    }

    @GetMapping
    public ResponseEntity<List<collegeModel>> getAllColleges() {
        return ResponseEntity.ok(collegeService.getAllColleges());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<collegeModel>> getCollegeById(@PathVariable Long id) {
        return ResponseEntity.ok(collegeService.getCollegeById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCollege(@PathVariable Long id) {
        collegeService.deleteCollege(id);
        return ResponseEntity.ok("College deleted successfully");
    }
}
