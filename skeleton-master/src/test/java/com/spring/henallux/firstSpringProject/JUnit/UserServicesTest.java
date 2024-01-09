package com.spring.henallux.firstSpringProject.JUnit;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.services.UserDetailsServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class UserServicesTest {
    private UserDAO userDAO;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO(userRepository, new ProviderConverter());
    }

    @Test
    void testUserDAO() {
        UserEntity mockedUserEntity = new UserEntity(
                0,
                "jdoe",
                "doe",
                "john",
                false,
                new Date(),
                "wellsecuredpassword",
                "Rue de Java 1, 1000 JavaCity",
                "john.doe@java.com",
                "0412345678",
                "ROLE_USER",
                true,
                true,
                true,
                true,
                "wellsecuredpassword"
        );
        when(userRepository.findByUsername("jdoe")).thenReturn(mockedUserEntity);
        assertThat(userDAO.usernameExists("jdoe")).isEqualTo(true);
    }
}