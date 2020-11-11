package com.example.adp1.repository;


import com.example.adp1.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>, QuerydslPredicateExecutor<Users> {
	Users findByUsername(String username);
}