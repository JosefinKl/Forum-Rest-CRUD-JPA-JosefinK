package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//Unit test for methods in a service class
class ChannelServiceTest {

    //Mock repository. Tests without database and Spring.
    ChannelRepository channelRepository = mock(ChannelRepository.class);
    ChannelService channelService = new ChannelService(channelRepository);

    //Test the get channel function.
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

    //Test to add a channel
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

    //Test updateChannel with a channel that does not exist in the database, hence an edge case.
    @Test
    void CallUpdateChannelWithNonexistingChannelShouldReturnNull() {
        //Arrange

        Channel channel = new Channel("TestUpdated","Test description updated");


        //Act
        Channel updateChannel = channelService.updateChannels(channel);

        assertNull(updateChannel);
    }

    //Test if a number is >10
    @Test
    void TestNumberOverTenShouldReturnTrueForNumberOverTen() {
        //Arrange
        Integer number = 100;

        //Act
        Boolean b = channelService.numberOverTen(number);

        //Assert
        assertTrue(b);
    }

    //Test if a number is >10
    @Test
    void TestNumberOverTenShouldReturnFalseForNumberUnderTen() {
        //Arrange
        Integer number = 2;

        //Act
        Boolean b = channelService.numberOverTen(number);

        //Assert
        assertFalse(b);
    }

    //Test if a number is >10 with edge value
    @Test
    void TestNumberUnderTenShouldReturnFalseForNumberTen() {
        //Arrange
        Integer number = 10;

        //Act
        Boolean b = channelService.numberOverTen(number);

        //Assert
        assertFalse(b);
    }

}