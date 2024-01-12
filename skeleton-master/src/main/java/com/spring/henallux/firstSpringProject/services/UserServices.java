package com.spring.henallux.firstSpringProject.services;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    private final UserDataAccess userDAO;

    @Autowired
    public UserServices(UserDataAccess userDAO){
        this.userDAO = userDAO;
    }

    public User findByUsername(String username){
        return userDAO.findByUsername(username);
    }

//    public void updateUser(int id, String username, String lastname, String firstname, String address, String email){
//        userDAO.updateUser(id, username, lastname, firstname, address, email);
//    }
    public void updateUser(String username, String lastname, String firstname, String address, String email){
        userDAO.updateUser(username, lastname, firstname, address, email);
    }
}
