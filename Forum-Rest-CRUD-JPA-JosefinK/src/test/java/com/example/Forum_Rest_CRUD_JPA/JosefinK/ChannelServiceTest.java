package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//Unit test for methods in a service class
class ChannelServiceTest {

    //Mock repository. Tests without database and Spring.
    ChannelRepository channelRepository = mock(ChannelRepository.class);
    ChannelService channelService = new ChannelService(channelRepository);

    @Test
    void getAllChannelsShouldReturnChannels() {
        //arrange
        Channel c1 = new Channel("Test1", "Test 1 description");
        Channel c2 = new Channel("Test2", "Test 2 description");
        List<Channel> mockChannels = List.of(c1, c2);

        when(channelRepository.findAll()).thenReturn(mockChannels);

        //act
        List<Channel> channels = channelService.getAllChannels();

        //assert
        assertNotNull(channels);
        assertEquals(mockChannels.size(), channels.size());
        assertEquals(mockChannels, channels);
    }

    @Test
    void addChannelShouldCallSaveRepository() {
        //arrange
        Channel channel = new Channel("Test","Test description");
        when(channelRepository.save(channel)).thenReturn(channel);

        //act

        Channel savedChannel = channelService.addChannel(channel);

        //assert
        verify(channelRepository).save(channel);
        assertNotNull(savedChannel);

    }
}