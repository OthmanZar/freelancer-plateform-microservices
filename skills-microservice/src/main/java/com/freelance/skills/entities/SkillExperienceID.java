package com.freelance.skills.entities;

import com.freelance.skills.enums.ExperienceType;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class SkillExperienceID implements Serializable {

    private String id;

    private String skillName;


}
