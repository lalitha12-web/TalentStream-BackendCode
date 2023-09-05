package com.bitlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitlabs.entity.Eligibility;
import com.bitlabs.repo.EligibilityRepository;

@Service
public class EligibilityService {
    EligibilityRepository eligibilityRepository;

    @Autowired
    public EligibilityService(EligibilityRepository eligibilityRepository) {
        this.eligibilityRepository = eligibilityRepository;
    }

    public Eligibility saveEligibility(Eligibility eligibility) {
        return eligibilityRepository.save(eligibility);
    }

    // Other methods if needed
}
