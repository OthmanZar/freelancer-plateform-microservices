package com.freelance.skills.repositories;

import com.freelance.skills.entities.SkillExperience;
import com.freelance.skills.entities.SkillExperienceID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<SkillExperience, SkillExperienceID> {

    List<SkillExperience> findSkillExperienceById_Id(String Id);

    List<SkillExperience> findSkillExperienceById_SkillName(String skillName);
}
