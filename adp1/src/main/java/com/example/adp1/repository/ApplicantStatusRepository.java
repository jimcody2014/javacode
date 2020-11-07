package com.example.adp1.repository;

import com.example.adp1.model.ApplicantStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantStatusRepository extends JpaRepository <ApplicantStatus, Long> {

}

