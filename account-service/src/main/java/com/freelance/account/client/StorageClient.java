package com.freelance.account.client;

import com.freelance.account.dto.SubcategoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@FeignClient(name = "storageClient", url = "http://localhost:5021")
public interface StorageClient {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,path = "/freelancer/profileImage")
    Optional<String> saveFreelancer_Profile_Image(@RequestPart("profileImage") MultipartFile profileImage);

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,path = "/freelancer/cv")
    Optional<String> saveFreelancer_Cv(@RequestPart("cv") MultipartFile cv);

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,path = "/client")
    Optional<String> saveClient_Profile_Image(@RequestPart("profile-image") MultipartFile cv);

    @GetMapping("/freelancer/profileImage/{profile-image}")
    byte[] getFreelancer_Profile_Image(@PathVariable("profile-image") String profileImage);

    @GetMapping("/freelancer/cv/{cv}")
    byte[] getFreelancer_Cv(@PathVariable("cv") String cv);

    @GetMapping("/client/{profile-image}")
    byte[] getClient_Profile_Image(@PathVariable("profile-image") String profileImage);
}