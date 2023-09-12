package com.bitlabs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitlabs.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    // You can add custom query methods here if needed
}
