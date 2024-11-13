package com.freelance.skills.services;

import com.freelance.skills.dtos.SkillRequest;

import java.util.List;
import java.util.Set;

public interface ISkillService {

    void createSkill(SkillRequest skillRequest);

    Set<String> getAllSkills();

    List<String> getSkillsOfFreelancer(Long id);

    List<Long> getFreelancersBySkill(String name);

}
