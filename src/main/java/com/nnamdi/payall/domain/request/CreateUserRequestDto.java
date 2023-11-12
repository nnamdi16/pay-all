package com.nnamdi.payall.domain.request;

import com.nnamdi.payall.model.base.AppConstant;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;


public class CreateUserRequestDto implements Serializable {
    @NotBlank(message = "Phone number must be provided")
    private String phoneNumber;

    @NotBlank(message = "Email must be provided")
    private String email;

    @NotBlank(message = "Password must be provided")
    private String password;


    private String firstName;


    private String lastName;


    private boolean isPinCreated;


    private boolean verified;


    private boolean kycVerified;


    private String refererId;


    private String refreshToken;


    private AppConstant.Role role;
}
