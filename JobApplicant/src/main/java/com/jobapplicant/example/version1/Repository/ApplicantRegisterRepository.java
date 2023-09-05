package com.jobapplicant.example.version1.Repository;

import com.jobapplicant.example.version1.Entity.ApplicantRegisterwithOTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRegisterRepository extends JpaRepository<ApplicantRegisterwithOTP, Integer> {
    Optional<ApplicantRegisterwithOTP> findByEmail(String email);

}
