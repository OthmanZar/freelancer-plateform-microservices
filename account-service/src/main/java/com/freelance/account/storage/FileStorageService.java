package com.freelance.account.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    @Value("${folders.cv}")
    String cvsFolder;


    @Value("${folders.profile}")
    String profileFolder;

    public String saveCvFile(MultipartFile image) {
        return saveImage(image, cvsFolder);
    }

    public String saveProfileImage(MultipartFile image) {
        return saveImage(image, profileFolder);
    }

    private String saveImage(MultipartFile image, String directoryPath) {
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



    public byte[] getCvFile(String imageName){
        return getImage(imageName,cvsFolder);
    }

    public byte[] getImageProfile(String imageName){
        return getImage(imageName,profileFolder);
    }
    byte[] getImage(String imageName,String folder){
        Path path=null;
        try{


            path= Paths.get(folder,imageName);

            Resource resource=new UrlResource(path.toUri());



            return resource.exists() && resource.isReadable()? Files.readAllBytes(path):null;


        }catch (Exception e){


        }
        return null;

    }



}
