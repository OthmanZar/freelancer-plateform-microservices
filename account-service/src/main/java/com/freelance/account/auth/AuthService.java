package com.freelance.account.auth;

import com.freelance.account.dto.FreelancerRequest;
import com.freelance.account.dto.LoginRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AuthService {


    public void registerFreelancer(FreelancerRequest request, MultipartFile image, MultipartFile cv);



    public void login(LoginRequest request);








}
