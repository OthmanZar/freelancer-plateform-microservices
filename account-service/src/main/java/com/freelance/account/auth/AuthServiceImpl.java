package com.freelance.account.auth;

import com.freelance.account.client.SkillsClient;
import com.freelance.account.dao.UserRepository;
import com.freelance.account.dto.request.ClientRequest;
import com.freelance.account.dto.request.FreelancerRequest;
import com.freelance.account.dto.request.LoginRequest;
import com.freelance.account.entities.AppUser;
import com.freelance.account.entities.Client;
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

    SkillsClient skillsClient;

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



        freelancer=userRepository.save(freelancer);



        request.getSkillRequest().setFreelancerId(freelancer.getId());


        skillsClient.createSkill(request.getSkillRequest());



    }


    @Override

    public void registerClient(ClientRequest request, MultipartFile image) {


        AppUser user=userRepository.findAppUserByEmail(request.getEmail());

        if(user!=null)
            throw new UserAlreadyExistException("Account already created by this email");

        if(!request.getPassword().equals(request.getConfirmPassword()))
            throw new PasswordConfirmationException("Confirmation password not similar to password !");




        Client client=mapper.fromClientRequest(request);


        String imageName= storageService.saveProfileImage(image);

        client.setImage(imageName);


        userRepository.save(client);

        //send activation code

    }





    @Override
    public void login(LoginRequest request) {



    }

}
