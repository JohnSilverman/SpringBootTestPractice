package com.example.springboottestpractice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@SpringBootTest
@ActiveProfiles("sandbox")
class SpringBootTestPracticeApplicationTests {

    @MockBean
    private Adder adder;

    @Test
    void contextLoads() {
        Integer a = 10, b = 20, answer = 40;
        given(adder.add(a, b)).willReturn(answer);
        Integer result = adder.add(a, b);
        assertThat(result).isEqualTo(40);
    }

    @Test
    void getPhase(){

    }

}
