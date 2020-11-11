package com.example.adp1.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.adp1.exception.ResourceNotFoundException;
import com.example.adp1.model.Applicant;
import com.example.adp1.repository.ApplicantRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Predicate;

@Service
public class ApplicantService {
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
	
	@Autowired
	ApplicantRepository applicantRepository;
  
    
    public Iterable<Applicant> getAllapplicants(Predicate predicate, Pageable pageable) {
        return applicantRepository.findAll(predicate, pageable);
    }
    
    public Applicant createApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }
    
    public ResponseEntity<?> runEverify(int initiatedByID) {
    	applicantRepository.EVERIFY_PROCEDURE(initiatedByID);
    	return new ResponseEntity<>("Procedure Run Complete", HttpStatus.OK);
    }
    
    public Applicant getApplicantById(Long applicantId) {
        return applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("applicant", "id", applicantId));
    }
    
    public int getApplicantCount() {
        return applicantRepository.getApplicantCount();
    }
    
    public ResponseEntity<?> updateApplicant(Long applicantId, Map<String,?> applicantdetails) {

    	Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("applicant", "id", applicantId));
	    ObjectMapper mapper = new ObjectMapper();
	    try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(applicantdetails));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    applicantdetails.forEach((key, value) -> {
	    	switch (key) {
	    	 case "applicantid":
	    		 applicant.setapplicantid(Long.valueOf(value + ""));
	    		 break;
	    	 case "applicantstatusid":
	    		 applicant.setapplicantstatusid(Long.valueOf(value + ""));
	    		 break;
	    	 case "officeid":
	    		 applicant.setofficeid(Long.valueOf(value + ""));
	    		 break;
	    	 case "userid":
	    		 applicant.setuserid(Long.valueOf(value + ""));
	    		 break;
	    	 case "everifyid":
	    		 applicant.seteverifyid(Long.valueOf(value + ""));
	    		 break;
	    	 case "reviewerid":
	    		 applicant.setreviewerid(Long.valueOf(value + ""));
	    		 break;
	    	 case "applicantlastname":
	    		 applicant.setapplicantlastname(value + "");
	    		 break;
	    	 case "applicantfirstname":
	    		 applicant.setapplicantfirstname(value + "");
	    		 break;
	    	 case "applicantmi":
	    		 applicant.setapplicantmi(value + "");
	    		 break;
	    	 case "applicantstreet":
	    		 applicant.setapplicantstreet(value + "");
	    		 break;
	    	 case "applicantaptnumber":
	    		 applicant.setapplicantaptnumber(value + "");
	    		 break;
	    	 case "applicantcity":
	    		 applicant.setapplicantcity(value + "");
	    		 break;
	    	 case "applicantstate":
	    		 applicant.setapplicantstate(value + "");
	    		 break;
	    	 case "applicantzip":
	    		 applicant.setapplicantzip(value + "");
	    		 break;
	    	 case "applicantbirthdate":
	    		 try {
					applicant.setapplicantbirthdate(format.parse(value+""));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 break;
	    	 case "applicantssn":
	    		 applicant.setapplicantssn(value + "");
	    		 break;
	    	 case "applicantemail":
	    		 applicant.setapplicantemail(value + "");
	    		 break;
	    	 case "applicantphone":
	    		 applicant.setapplicantphone(value + "");
	    		 break;
	    	 case "applicanthiredate":
	    		 try {
					applicant.setapplicanthiredate(format.parse(value+""));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		 break;
	    	}
	    });

    	applicantRepository.save(applicant);
    	
    	return new ResponseEntity<>("Applicant Updated", HttpStatus.OK);
    }
    
    public ResponseEntity<?> deleteApplicant(Long applicantId) {
    	Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("applicantStatus", "id", applicantId));

    	applicantRepository.delete(applicant);
    	
        return ResponseEntity.ok().build();
    }
}