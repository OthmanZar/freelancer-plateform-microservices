package com.freelance.skills.dtos;

import com.freelance.skills.enums.ExperienceType;
import com.freelance.skills.validations.EnumValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SkillRequest(

        @NotNull(message = "Freelancer ID must not be null")
        String freelancerId,
        @NotBlank(message = "Provide a skill name")
        String skillName,
        @EnumValue(enumClass = ExperienceType.class)
        ExperienceType experienceType

) {
}
