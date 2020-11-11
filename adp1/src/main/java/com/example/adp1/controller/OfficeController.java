package com.example.adp1.controller;

import com.example.adp1.service.OfficeService;
import com.querydsl.core.types.Predicate;
import com.example.adp1.model.Office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class OfficeController {
    
    @Autowired
    private OfficeService officeService;

    // Get All Office Records
    @GetMapping("/offices")
    @ResponseBody
    public Iterable<Office> getAllOffices(@QuerydslPredicate(root = Office.class) Predicate predicate, Pageable pageable) {
    	return this.officeService.getAllOffices(predicate, pageable);
    }
}