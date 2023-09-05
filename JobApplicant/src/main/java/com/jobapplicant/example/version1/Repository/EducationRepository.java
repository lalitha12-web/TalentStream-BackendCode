package com.jobapplicant.example.version1.Repository;

import com.jobapplicant.example.version1.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education,Long>
{
}
