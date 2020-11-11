package com.example.adp1.repository;

import com.example.adp1.model.Office;
import com.querydsl.core.types.dsl.StringPath;
import com.example.adp1.model.QOffice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long>, QuerydslPredicateExecutor<Office>, QuerydslBinderCustomizer<QOffice> {
	  @Override
	  default public void customize(QuerydslBindings bindings, QOffice root) {
	      bindings.bind(String.class).first(
	        (StringPath path, String value) -> path.containsIgnoreCase(value));
	  }
}