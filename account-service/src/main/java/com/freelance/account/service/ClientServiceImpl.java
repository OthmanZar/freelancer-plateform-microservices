package com.freelance.account.service;

import com.freelance.account.dao.UserRepository;
import com.freelance.account.dto.response.ClientResponse;
import com.freelance.account.entities.Client;
import com.freelance.account.mappers.AccountsMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor

public class ClientServiceImpl implements ClientService {


    UserRepository accountRepository;
    AccountsMapper mapper;



    @Override
    public ClientResponse findClientById(String id) {
        return accountRepository.findById(id)
                .map((client)->mapper.fromClientEntity((Client) client))
                .get();
    }
}
