package com.example.adp1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.adp1.exception.ResourceNotFoundException;
import com.example.adp1.model.ApplicantStatus;
import com.example.adp1.repository.ApplicantStatusRepository;

import java.util.List;

@Service
public class ApplicantStatusService {

    @Autowired
    ApplicantStatusRepository applicantStatusRepository;
    
    public List<ApplicantStatus> getAllApplicantStatuses() {
        return applicantStatusRepository.findAll();
    }
    
    public ApplicantStatus getApplicantStatusById(Long applicantStatusId) {
        return applicantStatusRepository.findById(applicantStatusId)
             .orElseThrow(() -> new ResourceNotFoundException("applicantstatus", "id", applicantStatusId));
   }
    public ApplicantStatus createApplicantStatus(ApplicantStatus applicantStatus) {
        return applicantStatusRepository.save(applicantStatus);
    }
    public ResponseEntity<?> deleteApplicantStatus(Long applicantStatusId) {
        ApplicantStatus applicantStatus = applicantStatusRepository.findById(applicantStatusId)
            .orElseThrow(() -> new ResourceNotFoundException("applicantStatus", "id", applicantStatusId));

        applicantStatusRepository.delete(applicantStatus);
        
        return new ResponseEntity<>("Applicant Deleted", HttpStatus.OK);
    }
 // Update an ApplicantStatus
    public ApplicantStatus updateApplicantStatus(Long applicantStatusId, ApplicantStatus applicantStatusDetails) {

        ApplicantStatus applicantStatus = applicantStatusRepository.findById(applicantStatusId)
        .orElseThrow(() -> new ResourceNotFoundException("applicantstatus", "id", applicantStatusId));

    //Call Model Setters and Getters

        applicantStatus.setapplicantstatusid(applicantStatusDetails.getapplicantstatusid());
        applicantStatus.setapplicantstatusdescription(applicantStatusDetails.getapplicantstatusdescription());

        ApplicantStatus updatedApplicantStatus = applicantStatusRepository.save(applicantStatus);
        
        return updatedApplicantStatus;
    }   

}

