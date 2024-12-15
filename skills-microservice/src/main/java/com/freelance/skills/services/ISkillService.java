package com.freelance.skills.services;

import com.freelance.skills.dtos.SkillRequest;

import java.util.List;
import java.util.Set;

public interface ISkillService {

    void createSkill(SkillRequest skillRequest);

    Set<String> getAllSkills();

    List<String> getSkillsOfFreelancer(String id);

    List<String> getFreelancersBySkill(String name);

}
