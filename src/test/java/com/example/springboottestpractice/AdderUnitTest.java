package com.example.springboottestpractice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdderUnitTest {

    private Adder adder;

    @BeforeEach
    void setUp() {
        adder = new Adder();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void add() {
        Integer a = 10, b = 20;
        assertThat(adder.add(a, b)).isEqualTo(a + b);
    }
}
