package com.example.adp1.repository;

import com.example.adp1.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository <Location, Long> {

}

