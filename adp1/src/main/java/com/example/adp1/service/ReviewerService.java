package com.example.adp1.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.adp1.exception.ResourceNotFoundException;
import com.example.adp1.model.Reviewer;
import com.example.adp1.repository.ReviewerRepository;
import com.querydsl.core.types.Predicate;

@Service
public class ReviewerService {

@Autowired
ReviewerRepository reviewerRepository;

DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);

    
    public Iterable<Reviewer> getAllReviewers(Predicate predicate, Pageable pageable) {
        return reviewerRepository.findAll(predicate, pageable);
    }
    
    public Reviewer getReviewerById(Long ReviewerId) {
        return reviewerRepository.findById(ReviewerId)
             .orElseThrow(() -> new ResourceNotFoundException("Reviewer", "id", ReviewerId));
    }

    public Reviewer createReviewer(Reviewer Reviewer) {
        return reviewerRepository.save(Reviewer);
    }
    
    public ResponseEntity<?> deleteReviewer(Long ReviewerId) {
        Reviewer reviewer = reviewerRepository.findById(ReviewerId)
            .orElseThrow(() -> new ResourceNotFoundException("Reviewer", "id", ReviewerId));

        reviewerRepository.delete(reviewer);
        
        return new ResponseEntity<>("Reviewer Deleted", HttpStatus.OK);
    }

    
    // Update an Reviewer
	public ResponseEntity<?> updateReviewer(Long reviewerId, Map<String,?> reviewerdetails) {

        Reviewer reviewer = reviewerRepository.findById(reviewerId)
            .orElseThrow(() -> new ResourceNotFoundException("reviewer", "id", reviewerId));

         reviewerdetails.forEach((key, value) -> {
               switch (key) {
                   case "reviewerid":
                       reviewer.setreviewerid(Long.valueOf(value + ""));
                       		break;
                   case "reviewerlastname":
                	   reviewer.setreviewerlastname(String.valueOf(value + ""));
                	   		break;
                   case "reviewerfirstname":
                	   reviewer.setreviewerfirstname(String.valueOf(value + ""));
                	   		break;
               
                   case "reviewercity":
                	   reviewer.setreviewercity(String.valueOf(value + ""));
                	   		break;
                   case "reviewerstate":
                	   reviewer.setreviewerstate(String.valueOf(value + ""));
                	   		break;
                   case "reviewerzip":
                	   reviewer.setreviewerzip(String.valueOf(value + ""));
                	   		break;                
                   
			    	}
			    });
         reviewerRepository.save(reviewer);
        
         return new ResponseEntity<>("Reviewer Updated", HttpStatus.OK);
    }
	
	
	public List<?> getApplicantStatusCount(Long reviewerid) {
        return reviewerRepository.getApplicantStatusCount(reviewerid);
    }

}

