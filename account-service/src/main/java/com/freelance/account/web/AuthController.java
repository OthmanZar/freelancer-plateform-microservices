package com.freelance.account.web;


import com.freelance.account.auth.AuthService;
import com.freelance.account.dto.request.ClientRequest;
import com.freelance.account.dto.request.FreelancerRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    AuthService authService;
    @PostMapping("/register/freelancers")
    public ResponseEntity<String> registerFreelancer(@RequestPart("freelancer")@Valid FreelancerRequest request,
                                                     @RequestPart("cv")MultipartFile cv,
                                                     @RequestPart("image")MultipartFile image){

        authService.registerFreelancer(request,image,cv);


        return ResponseEntity.ok("An activation code sent to your email ,please activate your account");


    }

    @PostMapping("/register/clients")
    public ResponseEntity<String> registerClient(@RequestPart("client")@Valid ClientRequest request,
                                                     @RequestPart("image")MultipartFile image){

        authService.registerClient(request,image);

        return ResponseEntity.ok("An activation code sent to your email ,please activate your account");


    }
}
