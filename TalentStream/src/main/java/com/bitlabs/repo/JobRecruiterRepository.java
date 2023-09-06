package com.bitlabs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitlabs.entity.JobRecruiter;

public interface JobRecruiterRepository extends JpaRepository<JobRecruiter, Long> {

	JobRecruiter findByEmail(String email);
    // Additional query methods can be defined here if needed

	boolean existsByEmail(String email);

	JobRecruiter findByrecruiterId(Long id);
}

