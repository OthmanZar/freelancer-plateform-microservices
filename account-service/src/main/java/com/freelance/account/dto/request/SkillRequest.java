package com.freelance.account.dto.request;


import com.freelance.account.enums.ExperienceType;
import com.freelance.account.validations.EnumValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class SkillRequest{

        @NotNull(message = "Freelancer ID must not be null")
        String freelancerId;

        @NotBlank(message = "Provide a skill name")
        String skillName;

        @EnumValue(enumClass = ExperienceType.class)
        ExperienceType experienceType;




}