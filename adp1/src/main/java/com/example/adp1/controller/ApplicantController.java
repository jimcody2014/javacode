package com.example.adp1.controller;

import com.example.adp1.service.ApplicantService;
import com.querydsl.core.types.Predicate;
import com.example.adp1.model.Applicant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class ApplicantController {
    
    @Autowired
    private ApplicantService applicantService;

    // Get All Applicant Records
    @GetMapping("/applicants")
    @ResponseBody
    public Iterable<Applicant> getAllapplicants(@QuerydslPredicate(root = Applicant.class) Predicate predicate, Pageable pageable) {
    	return this.applicantService.getAllapplicants(predicate, pageable);
    }

    // Create a new Applicant
    @PostMapping("/applicants")
    public Applicant createApplicant(@Valid @RequestBody Applicant newApplicant) {
    	return this.applicantService.createApplicant(newApplicant);
    }
    
    // Run a Stored Procedure
    @PostMapping("/runeverify/{id}")
    public ResponseEntity<?> runEverify(@PathVariable(value = "id") int initiatedByID) {
    	return this.applicantService.runEverify(initiatedByID);
    }

    // Get a Single Applicant Record by ID
    @GetMapping("/applicants/{id}")
    public Applicant getApplicantById(@PathVariable(value = "id") Long applicantId) {
        return this.applicantService.getApplicantById(applicantId);
    }
    
    // Get a Count of Applicants
    @GetMapping("/applicants/count")
    public int getApplicantCount() {
        return this.applicantService.getApplicantCount();
    }

    // Update an Existing Applicant by ID
    @PutMapping("/applicants/{id}")
    public ResponseEntity<?> updateApplicant(@PathVariable(value = "id") Long applicantId, @Valid @RequestBody Map<String,?> applicantdetails) {	
    	return this.applicantService.updateApplicant(applicantId, applicantdetails);
    }
    
    // Delete an Applicant
    @DeleteMapping("/applicants/{id}")
    public ResponseEntity<?> deleteApplicant(@PathVariable(value = "id") Long applicantId) {
    	return this.applicantService.deleteApplicant(applicantId);
    }
}