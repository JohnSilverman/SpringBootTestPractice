package com.example.springboottestpractice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GetMethodTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Adder adder;

    @Test
    public void getTest() throws Exception {
        String data = "DATA";

        mockMvc.perform(get("/echo")
                .param("data", data))
                .andExpect(status().isOk())
                .andExpect(content().string(data));
    }
}
