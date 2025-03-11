package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class ChannelsController {

    List<Channels> channelList = new ArrayList<>();


    public ChannelsController() {

    }


    @GetMapping("/channels")
    public List<Channels> getChannels() {
        return channelList;
    }

}
