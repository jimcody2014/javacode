package com.example.adp1.repository;

import com.example.adp1.model.Reviewer;
import com.querydsl.core.types.dsl.StringPath;
import com.example.adp1.model.QReviewer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long>, QuerydslPredicateExecutor<Reviewer>, QuerydslBinderCustomizer<QReviewer> {
  
  @Override
  default public void customize(QuerydslBindings bindings, QReviewer root) {
      bindings.bind(String.class).first(
        (StringPath path, String value) -> path.containsIgnoreCase(value));
  }
  
  @Query(value="SELECT ApplicantStatus.ApplicantStatusDescription, Count(*) from Applicant, Applicantstatus "
  		+ "where Applicant.ApplicantStatusID = ApplicantStatus.ApplicantStatusid "
  		+ "and Applicant.Reviewerid = :#{#reviewerid} Group by ApplicantStatus.ApplicantStatusDescription", nativeQuery=true)
  public List<?> getApplicantStatusCount(@Param("reviewerid") Long reviewerid);

}
