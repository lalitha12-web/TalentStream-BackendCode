package com.jobapplicant.example.Frontendversion.Repository;


import com.jobapplicant.example.Frontendversion.Entity.RegisterwithOTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterwithOTP, Integer> {
    Optional<RegisterwithOTP> findByEmail(String email);

}
