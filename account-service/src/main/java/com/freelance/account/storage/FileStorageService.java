package com.freelance.account.storage;

import com.freelance.account.client.StorageClient;
import com.freelance.account.exception.StorageException;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class FileStorageService {

    private final StorageClient storageClient;


    public String saveCvFile(MultipartFile image) {
        return storageClient.saveFreelancer_Cv(image).orElseThrow(() -> new StorageException("Could Not Upload The file"));
    }

    public String saveProfileImageFreelancer(MultipartFile image) {
        return storageClient.saveFreelancer_Profile_Image(image).orElseThrow(() -> new StorageException("Could Not Upload The file"));
    }
    public String saveProfileImageClient(MultipartFile image) {
        return storageClient.saveClient_Profile_Image(image).orElseThrow(() -> new StorageException("Could Not Upload The file"));
    }

    public byte[] getCvFile(String imageName){
        return storageClient.getFreelancer_Cv(imageName);
    }
    public byte[] getProfileFreelancer(String imageName){
        return storageClient.getFreelancer_Profile_Image(imageName);
    }
    public byte[] getProfileClient(String imageName){
        return storageClient.getClient_Profile_Image(imageName);
    }






}
