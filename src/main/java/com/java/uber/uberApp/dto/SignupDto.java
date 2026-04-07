package com.java.uber.uberApp.dto;

import com.java.uber.uberApp.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {

    private String name;
    private String  email;
    private String  password;



}
