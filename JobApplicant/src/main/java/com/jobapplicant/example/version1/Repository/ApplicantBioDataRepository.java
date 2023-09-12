package com.jobapplicant.example.version1.Repository;

import com.jobapplicant.example.version1.Entity.ApplicantBioData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantBioDataRepository extends JpaRepository<ApplicantBioData, Long> {
}
