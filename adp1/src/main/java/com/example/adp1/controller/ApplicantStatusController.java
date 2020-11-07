package com.example.adp1.controller;

import com.example.adp1.service.ApplicantStatusService;
import com.example.adp1.model.ApplicantStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;


@RestController
@RequestMapping("/rest")
public class ApplicantStatusController {
    
    @Autowired
    private ApplicantStatusService applicantStatusService;

    // Get All ApplicantStatus Records
    @GetMapping("/applicantstatus")
    @ResponseBody
    public List<ApplicantStatus> getAllApplicantStatuses() {
    return this.applicantStatusService.getAllApplicantStatuses();
    }
    
 // Get a Single ApplicantStatus Record by ID
    @GetMapping("/applicantstatus/{id}")
    public ApplicantStatus getApplicantStatusById(@PathVariable(value = "id") Long applicantStatusId) {
            return this.applicantStatusService.getApplicantStatusById(applicantStatusId);	
    }
    
 // Create a new ApplicantStatus
    @PostMapping("/applicantstatus")
    public ApplicantStatus createApplicantStatus(@Valid @RequestBody ApplicantStatus newApplicantStatus) {
        return this.applicantStatusService.createApplicantStatus(newApplicantStatus);
    }
 // Delete an ApplicantStatus
    @DeleteMapping("/applicantstatus/{id}")
    public ResponseEntity<?> deleteApplicant(@PathVariable(value = "id") Long applicantStatusId) {
        return this.applicantStatusService.deleteApplicantStatus(applicantStatusId);
    }
    
 // Update an Existing ApplicantStatus by ID
    @PutMapping("/applicantstatus/{id}")
    public ApplicantStatus updateApplicantStatus(@PathVariable(value = "id") Long applicantStatusId, 
         @Valid @RequestBody ApplicantStatus applicantStatusDetails) {

         return this.applicantStatusService.updateApplicantStatus(applicantStatusId, applicantStatusDetails);
    }



}


