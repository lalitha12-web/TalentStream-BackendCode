package com.jobapplicant.example.Frontendversion.Repository;

import com.jobapplicant.example.Frontendversion.Entity.ApplicantProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantProfileRepository extends JpaRepository<ApplicantProfile, Integer> {


}
