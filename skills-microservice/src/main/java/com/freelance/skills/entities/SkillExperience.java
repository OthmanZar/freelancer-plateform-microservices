package com.freelance.skills.entities;

import com.freelance.skills.enums.ExperienceType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkillExperience {

    @NonNull
    @EmbeddedId
    private SkillExperienceID id;

    @Enumerated(EnumType.STRING)
    private ExperienceType experienceType;




}
