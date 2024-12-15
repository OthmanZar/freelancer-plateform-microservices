package com.freelance.account.client;

import com.freelance.account.dto.SkillRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "skillClient", url = "http://localhost:5003")
public interface SkillsClient {
    @PostMapping("/api/v1/skills")
    void createSkill(@RequestBody SkillRequest requestSkill);


}