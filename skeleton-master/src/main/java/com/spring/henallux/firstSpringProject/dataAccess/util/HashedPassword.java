package com.spring.henallux.firstSpringProject.dataAccess.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashedPassword {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("Where");
        System.out.println(hashedPassword);
    }
}
