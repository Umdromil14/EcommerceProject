package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class UserDAO implements UserDataAccess{

    private final UserRepository userRepository;
    private final ProviderConverter providerConverter;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter){
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public User findByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            return null;
        }
        return providerConverter.userEntityToUserModel(userEntity);
    }

    @Override
    public boolean usernameExists(String username) {
        return  userRepository.findByUsername(username) != null;
    }

    @Override
    public void updateUser(String oldUsername, String username, String lastname, String firstname, String address, String email) {
        userRepository.updateUser(oldUsername, username, lastname, firstname, address, email);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(providerConverter.userModelToUserEntity(user));
    }
}
