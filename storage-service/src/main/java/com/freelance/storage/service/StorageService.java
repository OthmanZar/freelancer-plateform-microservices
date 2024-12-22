package com.freelance.storage.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class StorageService {

    @Value("${folders.freelancers.profile-images}")
    String freelancer_Profile_Images_Folder;

    @Value("${folders.freelancers.cvs}")
    String freelancer_Cvs_Folder;

    @Value("${folders.clients}")
    String client_Profile_Images_Folder;

    @Value("${folders.offers}")
    String offer_Attachements_Folder;

    public String saveFreelancer_ProfileImage(MultipartFile profileImage) {
        return saveFile(profileImage, freelancer_Profile_Images_Folder);
    }

    public String saveFreelancer_CV(MultipartFile cv) {
        return saveFile(cv, freelancer_Cvs_Folder);
    }

    public String saveClient_ProfileImage(MultipartFile profileImage) {
        return saveFile(profileImage, client_Profile_Images_Folder);
    }

    public List<String> saveOffer_Attachements(MultipartFile[] attachements) {
        List<String> names = new ArrayList<>();
        for (MultipartFile attachement : attachements) {
            names.add(saveFile(attachement, offer_Attachements_Folder));
        }

        return names;
    }



    public byte[] getFreelancer_ProfileImage(String profileImage) throws IOException {
        return getFile(profileImage,freelancer_Profile_Images_Folder);
    }

    public byte[]getFreelancer_CV(String cv) throws IOException {
        return getFile(cv,freelancer_Cvs_Folder);
    }

    public byte[] getClient_ProfileImage(String profileImage) throws IOException {
        return getFile(profileImage, client_Profile_Images_Folder);
    }

    public byte[] getOffer_Attachements(String attachement) throws IOException {

        return getFile(attachement, offer_Attachements_Folder);
    }


    private String saveFile(MultipartFile image, String directoryPath) {
        // Validate the uploaded file
        if (image.isEmpty()) {
            throw new IllegalArgumentException("File is empty. Please upload a valid image.");
        }

        // Generate a unique name for the file to prevent overwriting
        String imageName = System.currentTimeMillis() + "_" + image.getOriginalFilename();

        // Create the directory if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Save the file
        File destinationFile = new File(directory, imageName);
        try {
            image.transferTo(destinationFile);
            System.out.println("Image saved successfully: " + destinationFile.getAbsolutePath());
            return imageName; // Return the name or path of the saved image
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image: " + e.getMessage(), e);
        }
    }


     private byte[] getFile(String fileName, String folder) throws IOException {
        Path path = null;

            path = Paths.get(folder, fileName);

            Resource resource = new UrlResource(path.toUri());


            return resource.exists() && resource.isReadable() ? Files.readAllBytes(path) : null;


    }
}
