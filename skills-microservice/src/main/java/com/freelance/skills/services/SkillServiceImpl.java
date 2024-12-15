package com.freelance.skills.services;

import com.freelance.skills.dtos.SkillRequest;
import com.freelance.skills.entities.SkillExperience;
import com.freelance.skills.entities.SkillExperienceID;
import com.freelance.skills.repositories.SkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SkillServiceImpl implements ISkillService {
    private SkillRepository skillRepository;
    @Override
    public void createSkill(SkillRequest skillRequest) {

        SkillExperienceID skillExperienceID = new SkillExperienceID();
        skillExperienceID.setSkillName(skillRequest.skillName().toUpperCase());
        skillExperienceID.setId(skillRequest.freelancerId());

       skillRepository.save(SkillExperience.builder()
                       .id(skillExperienceID)
                       .experienceType(skillRequest.experienceType())
               .build());


    }

    @Override
    public Set<String> getAllSkills() {

        return skillRepository.findAll().stream().map(skillExperience -> skillExperience.getId().getSkillName()).collect(Collectors.toSet());
    }

    @Override
    public List<String> getSkillsOfFreelancer(String id) {

        List<SkillExperience> skillExperiences = skillRepository.findSkillExperienceById_Id(id);

        if(skillExperiences.isEmpty()){
            return List.of();
        }


        return skillExperiences.stream().map(skillExperience -> skillExperience.getId().getSkillName()).toList();
    }

    @Override
    public List<String> getFreelancersBySkill(String name) {
        List<SkillExperience> skillExperiences = skillRepository.findSkillExperienceById_SkillName(name);

        if(skillExperiences.isEmpty()){
            return List.of();
        }
        return skillExperiences.stream().map(skillExperience -> skillExperience.getId().getId()).toList();
    }
}
