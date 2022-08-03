package com.myorg.iplWinningPrediction.service.serviceImpl;

import com.myorg.iplWinningPrediction.model.User;
import com.myorg.iplWinningPrediction.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    //@Autowired  annotation to autowire in UserServiceImpl .
    // The @InjectMock the annotation will initialize the  UserServiceImpl  object with the UserRepository mock.
    @InjectMocks
    @Autowired
    private UserServiceImpl userService;

    //At run time, Mockito will create a mock of UserRepository
    @Mock private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;

    private User user1;
    private User user2;
    private List<User> userList;

    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();
        user1 = User.builder()
                .userId(1)
                .name("User 1")
                .email("user1@gmail.com")
                .mobileNumber("123456789")
                .password("user123456")
                .build();
        user2 = User.builder()
                .userId(2)
                .name("User 2")
                .email("user2@gmail.com")
                .mobileNumber("3322115522")
                .password("user123456")
                .build();
        userList.add(user1);
        userList.add(user2);
    }

    @AfterEach
    void tearDown() {
        user1 = user2 = null;
        userList = null;
    }

    @Test
    void shouldAddUser() {
        //given
        given(userRepository.existsUserByEmail(user1.getEmail())).willReturn(false);
        given(userRepository.existsUserByMobileNumber(user1.getMobileNumber())).willReturn(false);
        //when
        String msg = userService.addUser(user1);
        //then
        assertThat(msg).isEqualTo("User created successfully");
        verify(userRepository,times(1)).save(user1);

    }
    @Test
    void shouldGetUserById() {
        when(userRepository.findById(1)).thenReturn(user1);
        assertThat(userService.getUserById(user1.getUserId())).isEqualTo(user1);
    }

    @Test
    void shouldGetAllUser() {
        //given
        given(userRepository.findAll()).willReturn(userList);
        //when
        when(userRepository.findAll()).thenReturn(userList);
        //then
        List<User> expected = userService.getAllUser();
        assertEquals(2, expected.size());
        verify(userRepository,times(1)).findAll();

    }
}