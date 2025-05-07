package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

//Unit test for methods in a service class
class ChannelServiceTest {

    ChannelRepository channelRepository = mock(ChannelRepository.class);
    ChannelService channelService = new ChannelService(channelRepository);

    @Test
    void getAllChannels() {
        //arrange


        //act


        //assert
    }

    @Test
    void deleteChannels() {
        //arrange
        //act
        //assert
    }
}