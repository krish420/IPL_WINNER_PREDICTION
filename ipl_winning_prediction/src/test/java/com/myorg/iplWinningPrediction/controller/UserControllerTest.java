package com.myorg.iplWinningPrediction.controller;

import com.myorg.iplWinningPrediction.model.User;
import com.myorg.iplWinningPrediction.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private UserService mockUserService;
    private User user1;
    private User user2;
    private List<User> userList;


    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();
        user1 = User.builder()
                .userId(1)
                .name("TEST USER 1")
                .mobileNumber("1234567891")
                .email("tu1@gmail.com")
                .password("user123456")
                .build();
        user2 = User.builder()
                .userId(2)
                .name("TEST USER 2")
                .mobileNumber("3214567891")
                .email("tu2@gmail.com")
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
    void canAddUser() throws Exception {
        when(mockUserService.addUser(user1)).thenReturn("User created successfully");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/signup");
        ResultActions perform = mockMvc.perform(requestBuilder);
        MvcResult result = perform.andReturn();
        MockHttpServletResponse res = result.getResponse();
        String msg = res.toString();
        System.out.println(msg);


    }

    @Test
    void userLogin() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void getAllUser() {
    }
}