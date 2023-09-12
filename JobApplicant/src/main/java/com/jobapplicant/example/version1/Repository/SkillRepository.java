package com.jobapplicant.example.version1.Repository;

import com.jobapplicant.example.version1.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long >
{
}
