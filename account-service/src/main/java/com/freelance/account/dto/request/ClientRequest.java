package com.freelance.account.dto.request;

import com.freelance.account.dto.request.AbstractRequest;
import com.freelance.account.enums.Sex;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ClientRequest extends AbstractRequest {

    @NotNull(message = "birthday is mandatory")

    LocalDate birthDay;


    @NotNull(message = "sex is mandatory")

    Sex sex;



}
