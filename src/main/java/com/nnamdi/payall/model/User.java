package com.nnamdi.payall.model;

import com.nnamdi.payall.model.base.AbstractBaseEntity;
import com.nnamdi.payall.model.base.AppConstant;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Table(name = "users", indexes = {
        @Index(columnList = "phoneNumber", name = "idx_phone_number", unique = true),
        @Index(columnList = "email", name = "idx_email")
})
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractBaseEntity implements Serializable {
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="is_pin_created")
    private boolean isPinCreated;

    @Column(name = "verified")
    private boolean verified;

    @Column(name = "kyc_verified")
    private boolean kycVerified;

    @JoinColumn(name = "referer_id")
    @ManyToOne
    private User refererId;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "role")
    private AppConstant.Role role;
}
