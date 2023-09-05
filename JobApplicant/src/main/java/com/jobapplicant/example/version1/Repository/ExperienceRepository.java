package com.jobapplicant.example.version1.Repository;

import com.jobapplicant.example.version1.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience,Long> {
}
