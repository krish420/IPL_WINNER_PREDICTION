package com.myorg.iplWinningPrediction.service.serviceImpl;

import com.myorg.iplWinningPrediction.model.Matches;
import com.myorg.iplWinningPrediction.repository.MatchRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MatchServiceImplTest {

    @InjectMocks @Autowired private MatchServiceImpl matchService;
    @Mock MatchRepository matchRepository;
    private List<Matches> matchesList;
    private Matches match1;
    private Matches match2;
    @BeforeEach
    void setUp() {
        matchesList = new ArrayList<>();
        match1 = Matches.builder()
                .match_id(1)
                .teamA("MI")
                .teamB("CSK")
                .date("8/2/2022").build();
        match2 = Matches.builder()
                .match_id(2)
                .teamA("RCB")
                .teamB("KKR")
                .date("9/2/2022").build();
        matchesList.add(match1);
        matchesList.add(match2);

    }

    @AfterEach
    void tearDown() {
        match1 = match2 = null;
        matchesList = null;

    }

    @Test
    void shouldAddMatches() {
        String msg = matchService.addMatches(match1);
        assertThat("Match Added").isEqualTo(msg);
        verify(matchRepository,times(1)).save(match1);
    }

    @Test
    void shouldGetAllMatch() {
        //given
        given(matchRepository.findAll()).willReturn(matchesList);
        List<Matches> expected = matchService.getAllMatch();
        assertThat(expected).isEqualTo(matchesList);
        verify(matchRepository).findAll();


    }

    @Test
    void shouldGetMathByDate() {
        //given
        given(matchRepository.findAll()).willReturn(matchesList);
        //
        Matches expectedMatch = matchService.getMathByDate(match1.getDate());
        assertThat(expectedMatch).isEqualTo(match1);
    }
}