package com.freelance.skills.entities;

import com.freelance.skills.enums.ExperienceType;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class SkillExperienceID {

    private Long id;

    private String skillName;


}
