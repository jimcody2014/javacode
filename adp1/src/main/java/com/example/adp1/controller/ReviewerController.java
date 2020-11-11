
package com.example.adp1.controller;

import com.example.adp1.service.ReviewerService;
import com.querydsl.core.types.Predicate;
import com.example.adp1.model.Reviewer;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class ReviewerController {

    @Autowired
    private ReviewerService reviewerService;

    // Get All Reviewer Records
    @GetMapping("/reviewer")
    @ResponseBody
    public Iterable<Reviewer> getAllReviewers(@QuerydslPredicate(root = Reviewer.class) Predicate predicate, Pageable pageable) {
        return this.reviewerService.getAllReviewers(predicate, pageable);
    }
    
    // Get Applicant Status count of one reviewer
    @GetMapping("/reviewercountstatus/{id}")
    @ResponseBody
    public List<?> getApplicantStatusCount(@PathVariable(value = "id") Long reviewerid) {
        return this.reviewerService.getApplicantStatusCount(reviewerid);
    }
    
 // Get a Single Reviewer Record by ID
    @GetMapping("/reviewer/{id}")
    public Reviewer getReviewerById(@PathVariable(value = "id") Long reviewerId) {
            return this.reviewerService.getReviewerById(reviewerId);	
    }
    
    // Create a new Reviewer
    @PostMapping("/reviewer")
    public Reviewer createReviewer(@Valid @RequestBody Reviewer newReviewer) {
        return this.reviewerService.createReviewer(newReviewer);
    }

    // Delete an Reviewer
    @DeleteMapping("/reviewer/{id}")
    public ResponseEntity<?> deleteReviewer(@PathVariable(value = "id") Long reviewerId) {
        return this.reviewerService.deleteReviewer(reviewerId);
    }
    
    // Update an Existing Reviewer by ID
    @PutMapping("/reviewer/{id}")
    public ResponseEntity<?> updateReviewer(@PathVariable(value = "id") Long reviewerId, @Valid @RequestBody Map<String,?> reviewerdetails) {

        return this.reviewerService.updateReviewer(reviewerId, reviewerdetails);
    }
}