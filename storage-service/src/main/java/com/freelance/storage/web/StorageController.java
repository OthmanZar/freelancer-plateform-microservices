package com.freelance.storage.web;

import com.freelance.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/storage")
@RequiredArgsConstructor
public class StorageController {

    private final StorageService storageService;


    @PostMapping("/freelancer/profileImage")
    public ResponseEntity<String> saveFreelancer_Profile_Image(@RequestParam("profile-image") MultipartFile profileImage){
        String pathName=storageService.saveFreelancer_ProfileImage(profileImage);

        return ResponseEntity.ok(pathName);
    }

    @PostMapping("/freelancer/cv")
    public ResponseEntity<String> saveFreelancer_Cv(@RequestParam("cv") MultipartFile cv){
        String pathName=storageService.saveFreelancer_CV(cv);

        return ResponseEntity.ok(pathName);
    }

    @PostMapping("/client")
    public ResponseEntity<String> saveClient_Profile_Image(@RequestParam("profile-image") MultipartFile profileImage){
        String pathName=storageService.saveClient_ProfileImage(profileImage);

        return ResponseEntity.ok(pathName);
    }

    @PostMapping("/offer")
    public ResponseEntity<List<String>> saveOffer_Attachements(@RequestParam("attachements") MultipartFile[] attachements){
        List<String> pathName=storageService.saveOffer_Attachements(attachements);

        return ResponseEntity.ok(pathName);
    }

    @GetMapping("/freelancer/profileImage/{profile-image}")
    public ResponseEntity<byte[]> getFreelancer_Profile_Image(@PathVariable("profile-image") String profileImage) throws IOException {
        byte[] pathName=storageService.getFreelancer_ProfileImage(profileImage);

        return ResponseEntity.ok(pathName);
    }

    @GetMapping("/freelancer/cv/{cv}")
    public ResponseEntity<byte[]> getFreelancer_Cv(@PathVariable("cv") String cv) throws IOException {
        byte[] pathName=storageService.getFreelancer_CV(cv);

        return ResponseEntity.ok(pathName);
    }

    @GetMapping("/client/{profile-image}")
    public ResponseEntity<byte[]> getClient_Profile_Image(@PathVariable("profile-image") String profileImage) throws IOException {
        byte[] pathName=storageService.getClient_ProfileImage(profileImage);

        return ResponseEntity.ok(pathName);
    }

    @GetMapping("/offer/{attachement}")
    public ResponseEntity<byte[]> getOffer_Attachement(@PathVariable("attachement") String attachement) throws IOException {
        byte[] pathName=storageService.getOffer_Attachements(attachement);

        return ResponseEntity.ok(pathName);
    }
}
