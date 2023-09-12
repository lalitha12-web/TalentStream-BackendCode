package com.bitlabs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitlabs.entity.Eligibility;

@Repository
public interface EligibilityRepository extends JpaRepository<Eligibility, Long> {
    // Custom methods if needed
}
