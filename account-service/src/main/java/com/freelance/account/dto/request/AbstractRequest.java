package com.freelance.account.dto.request;

import com.freelance.account.enums.Sex;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;


@Data


public abstract class AbstractRequest {

    @NotEmpty(message = "firstname is mandatory")
    @NotNull(message = "firstname is mandatory")
    String firstName;

    @NotEmpty(message = "lastname is mandatory")
    @NotNull(message = "lastname is mandatory")
    String lastName;

    @NotEmpty(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    @Size(min = 8, message = "Password should be 8 characters long minimum")

    String password;

    @NotBlank(message = "Confirm password is required")
    @Size(min = 8, message = "Confirm password must be at least 8 characters long")
    private String confirmPassword;

    @Email(message = "Email is not well formatted")
    @NotEmpty(message = "Email is mandatory")
    @NotNull(message = "Email is mandatory")
    String email;










}
