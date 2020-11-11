package com.example.adp1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.adp1.model.Office;
import com.example.adp1.repository.OfficeRepository;
import com.querydsl.core.types.Predicate;

@Service
public class OfficeService {
	
	@Autowired
	OfficeRepository officeRepository;
    
    public Iterable<Office> getAllOffices(Predicate predicate, Pageable pageable) {
        return officeRepository.findAll(predicate, pageable);
    }
    
}
