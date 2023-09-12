package com.jobapplicant.example.version1.Repository;

import com.jobapplicant.example.version1.Entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Long> {
}
