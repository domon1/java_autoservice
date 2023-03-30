package com.course.project.carservice.repository;

import com.course.project.carservice.IntegrationTestBase;
import com.course.project.carservice.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest extends IntegrationTestBase {

    /*@Autowired
    private UserRepository userRepository;

    public static final Long USER_ID = 1L;
    public static final String USER_LOGIN = "komarov@mail.ru";
    public static final String USER_PASSWORD = "simple_password";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }*/

   /* @Test
    void testFindById(){
        Optional<User> user = userRepository.findById(USER_ID);
        assertTrue(user.isPresent());
        user.ifPresent( entity -> {
            assertEquals(USER_LOGIN, entity.getLogin());
            assertEquals(USER_PASSWORD, entity.getPassword());
        });
    }

    @Test
    void testFindByLogin(){
        Optional<User> user = userRepository.findByLogin(USER_LOGIN);
        assertTrue(user.isPresent());
    }*/

}