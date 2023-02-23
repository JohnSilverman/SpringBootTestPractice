package com.example.springboottestpractice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

// Controller 등 웹 관련 빈만 주입되고 Service, Component 등은 주입 안됨
// 필요한 빈은 MockBean 해야됨
/*
 * @WebMvcTest가 주입하는 빈 종류들
 *
 * @Controller, @ControllerAdvice, @JsonComponent,
 * Converter, GenericConverter, Filter, HandlerInterceptor,
 * WebMvcConfigurer, HandlerMethodArgumentResolver
 */
@WebMvcTest
class WebMvcControllerTest {

    @Autowired
    WebTestClient client;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    Adder adder;

    @Test
    void addTestWebTestClientVersion(){
        AddRequest body = new AddRequest();
        Integer a = 10;
        body.setA(a);
        Integer b = 20;
        body.setB(b);

        given(adder.add(a, b)).willReturn(a + b);

        client.post().uri("/add")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(body), AddRequest.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isEqualTo(a + b);
    }

}
