package com.myorg.iplWinningPrediction.repository;

import com.myorg.iplWinningPrediction.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {




    @Autowired
    private UserRepository testRepository;
    private User actualUser;

    @BeforeEach
    void setUp() {
        actualUser = User.builder()
                .userId(1)
                .name("Test User")
                .email("testUser@gmail.com")
                .password("user123456")
                .mobileNumber("1122334499")
                .build();
        testRepository.save(actualUser);
    }


    @AfterEach
    void tearDown() {
        testRepository.deleteAll();
        actualUser = null;
    }

    @Test
    void itShouldCheckIfUserExistsByEmail() {
        //given
        String email = actualUser.getEmail();
        //when
        boolean expected = testRepository.existsUserByEmail(email);
        //then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckIfUserExistsByMobileNumber() {
        //given
        String mobileNumber = actualUser.getMobileNumber();
        //when
        boolean expectedUser = testRepository.existsUserByMobileNumber(mobileNumber);
        //then
        assertThat(expectedUser).isTrue();
    }

    @Test
    void itShouldCheckIfWeCanFindUserByEmail() {
        //given
        String email = actualUser.getEmail();
        //when
        User expectedUser = testRepository.findByEmail(email);
        //then
        assertThat(actualUser.toString()).isEqualTo(expectedUser.toString());

    }

    @Test
    void itShouldCheckIfWeCanFindUserFindById() {
        //given
        int userId = actualUser.getUserId();
        //when
        User expectedUser = testRepository.findById(userId);
        //then
        assertThat(actualUser.toString()).isEqualTo(expectedUser.toString());
    }

}