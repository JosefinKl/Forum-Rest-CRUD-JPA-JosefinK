package com.example.Forum_Rest_CRUD_JPA.JosefinK;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Component test
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
class ChannelControllerTest {

    //Mock repository.
    ChannelRepository channelRepository = mock(ChannelRepository.class);

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private ChannelRepository channelRepository;
    @Autowired
    private ObjectMapper objectMapper;

//    @LocalServerPort
//    private int port;

    //Test to control the creation of a new channel.
    @Test
    void TestCreateChannel() throws Exception {

        //Arrange
        Channel newChannel = new Channel("TestChannel", "Test Description");

        //Act & Assert
        mockMvc.perform(post("/channels")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newChannel)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("TestChannel")))
                .andExpect(jsonPath("$.description", is("Test Description")));

    }

    @Test
    void TestAddAndDeleteChannels() throws Exception {
        //Arrange
        Channel newChannel = new Channel("TestChannel", "Test Description");
        when(channelRepository.findAll()).thenReturn(List.of(newChannel));

        //Act & Assert adding channel
        mockMvc.perform(post("/channels")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newChannel)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("TestChannel")))
                .andExpect(jsonPath("$.description", is("Test Description")));


        //act & Assert
        when(channelRepository.findAll()).thenReturn(List.of(newChannel));
        List<Channel> savedChannel = channelRepository.findAll();
        Channel savedChannel1 = savedChannel.get(0);
        long idSavedChannel1 = savedChannel1.getId();


        mockMvc.perform(MockMvcRequestBuilders.delete("/channels/" + idSavedChannel1))
                .andExpect(status().isOk());
    }
}