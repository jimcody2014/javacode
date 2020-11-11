package com.example.adp1.repository;

import com.example.adp1.model.Applicant;
import com.example.adp1.model.QApplicant;
import com.querydsl.core.types.dsl.StringPath;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long>, QuerydslPredicateExecutor<Applicant>, QuerydslBinderCustomizer<QApplicant> {
	  @Override
	  default public void customize(QuerydslBindings bindings, QApplicant root) {
	      bindings.bind(String.class).first(
	        (StringPath path, String value) -> path.containsIgnoreCase(value));
	  }
	  
	@Query("SELECT COUNT(a.applicantid) from Applicant a")
	int getApplicantCount();
	
    @Procedure(name = "EVERIFY_PROCEDURE")
    void EVERIFY_PROCEDURE(@Param("in_InitiatedBy") int inParam1);
}