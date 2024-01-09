package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);

    @Modifying
    @Query("UPDATE UserEntity u SET u.username = :username, u.lastname = :lastname, u.firstname = :firstname, u.address = :address, u.email = :email where u.id = :id")
    void updateUser(@Param(value = "id") int id, @Param(value = "username") String username, @Param(value = "lastname") String lastname, @Param(value="firstname") String firstname, @Param(value = "address") String address, @Param(value="email") String email);
}
