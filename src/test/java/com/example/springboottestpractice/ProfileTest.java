package com.example.springboottestpractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@ActiveProfiles("sandbox")
class ProfileTest {

    @Value("${test.phase}")
    private String PHASE;

    @Test
    void getPhase(){
        assertThat(PHASE).isEqualTo("sandbox");
    }
}
