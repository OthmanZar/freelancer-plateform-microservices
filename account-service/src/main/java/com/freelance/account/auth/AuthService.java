package com.freelance.account.auth;

import com.freelance.account.dto.request.ClientRequest;
import com.freelance.account.dto.request.FreelancerRequest;
import com.freelance.account.dto.request.LoginRequest;
import org.springframework.web.multipart.MultipartFile;

public interface AuthService {


    public void registerFreelancer(FreelancerRequest request, MultipartFile image, MultipartFile cv);

    public void registerClient(ClientRequest request, MultipartFile image );



    public void login(LoginRequest request);








}
