package com.example.springboottestpractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringJUnitConfig
class ControllerWebTestClientTest {

    WebTestClient client;

    @BeforeEach
    void setUp() {
        client = WebTestClient.bindToController(new OperationController(new Adder())).build();
    }

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
