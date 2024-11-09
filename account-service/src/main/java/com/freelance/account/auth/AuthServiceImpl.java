package com.freelance.account.auth;

import com.freelance.account.dao.UserRepository;
import com.freelance.account.dto.FreelancerRequest;
import com.freelance.account.dto.LoginRequest;
import com.freelance.account.entities.AppUser;
import com.freelance.account.entities.Freelancer;
import com.freelance.account.exception.PasswordConfirmationException;
import com.freelance.account.exception.UserAlreadyExistException;
import com.freelance.account.mappers.AccountsMapper;
import com.freelance.account.storage.FileStorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements  AuthService {

    UserRepository userRepository;

    AccountsMapper mapper;

    FileStorageService storageService;



    @Override

    public void registerFreelancer(FreelancerRequest request, MultipartFile image,MultipartFile cv) {


        AppUser user=userRepository.findAppUserByEmail(request.getEmail());

        if(user!=null)
            throw new UserAlreadyExistException("Account already created by this email");

        if(!request.getPassword().equals(request.getConfirmPassword()))
            throw new PasswordConfirmationException("Confirmation password not similar to password !");

        Freelancer freelancer=mapper.fromRequest(request);


        String imageName= storageService.saveProfileImage(image);
        String cvPath=storageService.saveCvFile(cv);

        freelancer.setCv(cvPath);
        freelancer.setImage(imageName);

        userRepository.save(freelancer);






    }



    @Override
    public void login(LoginRequest request) {



    }
}
