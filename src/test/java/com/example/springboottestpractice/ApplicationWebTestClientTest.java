package com.example.springboottestpractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest
@AutoConfigureMockMvc //없으면 빈 생성이 안돼서 Autowired가 안됨.
class ApplicationWebTestClientTest {

    @Autowired
    WebTestClient client;

    @Test
    void addApiTest(){
        Integer a = 10, b = 20;

        AddRequest body = new AddRequest();
        body.setA(a);
        body.setB(b);

        client.post().uri("/add")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(body), AddRequest.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isEqualTo(a + b);
    }
}
