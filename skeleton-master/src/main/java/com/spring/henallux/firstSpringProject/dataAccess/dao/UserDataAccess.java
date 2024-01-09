package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.User;

public interface UserDataAccess {
    User findByUsername(String username);
    boolean usernameExists(String username);
    void updateUser(int id, String username, String lastname, String firstname, String address, String email);
    void createUser(User user);
}
