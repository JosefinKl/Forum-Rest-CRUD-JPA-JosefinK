package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Integration test to test the whole chain, controller, service, repository and mySQL. Uses a test properties file to make sure a test database will be used for the test, hence isolated from production database.
@ActiveProfiles("test") //to use a test database isolated from production database (with create-drop, hence the table and its content will be created at start and dropped at the end)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChannelControllerTestIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateChannelAndGetallChannelsbyHTTP(){
        Channel newChannel = new Channel("Test", "Test desciption");

        ResponseEntity<Channel>postResponse = restTemplate.postForEntity("http://localhost:" + port + "/channels", newChannel, Channel.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode() );


        ResponseEntity<List<Channel>> response = restTemplate.exchange(
                "http://localhost:" + port + "/channels",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Channel>>() {}
        );

        List<Channel> channels = response.getBody();
        String name = channels.get(0).getName();
        String description = channels.get(0).getDescription();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Test", name);
        assertEquals("Test desciption", description);


    }

}