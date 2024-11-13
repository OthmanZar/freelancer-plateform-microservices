package com.freelance.skills.web;

import com.freelance.skills.dtos.SkillRequest;
import com.freelance.skills.services.ISkillService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/skills")
public class SkillController {

    private final ISkillService skillService;

    @PostMapping
    public ResponseEntity<?> createCategory(
            @RequestBody @Valid SkillRequest skillRequest
    ){
        skillService.createSkill(skillRequest);
        return ResponseEntity.ok("Done");
    }

    @GetMapping
    public ResponseEntity<Set<String>> getAllSkills(){
        return ResponseEntity.ok(skillService.getAllSkills());
    }

    @GetMapping("/freelancer/{id}")
    public ResponseEntity<List<String>> getSkillsOfFreelancer(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(skillService.getSkillsOfFreelancer(id));
    }

    @GetMapping("/{skill}")
    public ResponseEntity<List<Long>> getFreelancerBySkills(
            @PathVariable String skill
    ){
        return ResponseEntity.ok(skillService.getFreelancersBySkill(skill));
    }

}
