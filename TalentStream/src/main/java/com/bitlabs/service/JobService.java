package com.bitlabs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitlabs.entity.Job;
import com.bitlabs.repo.JobRecruiterRepository;
import com.bitlabs.repo.JobRepository;

@Service
public class JobService {
    JobRepository jobRepository;
    JobRecruiterRepository recruiterRepository;

    @Autowired
    public JobService(JobRepository jobRepository, JobRecruiterRepository recruiterRepository) {
        this.jobRepository = jobRepository;
        this.recruiterRepository =recruiterRepository;
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
  

    // Other methods for retrieving, updating, and deleting jobs if needed
}

