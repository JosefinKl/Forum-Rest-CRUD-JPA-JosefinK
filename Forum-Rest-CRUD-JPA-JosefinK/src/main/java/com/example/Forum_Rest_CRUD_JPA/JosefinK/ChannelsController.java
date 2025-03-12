package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class ChannelsController {

    List<Channel> channels = new ArrayList<>();

    private final ChannelsService channelsService;

    public ChannelsController(ChannelsService channelsService) {
        this.channelsService = channelsService;
    }

    @PostMapping
    public ResponseEntity<Channels> createChannelsByResponseBody(@Valid @RequestBody Channels channels) {

        Channels c1 = channelsService.addChannels(channels);
        return ResponseEntity.ok(c1);
    }

    @PutMapping
    public ResponseEntity<Channels> updateChannelsById(@Valid @RequestBody Channels newChannels) throws Exception {
        Channels c1 = channelsService.updateChannels(newChannels);

        if(c1 != null) {
            return ResponseEntity.accepted().body(newChannels);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/channels/{id}")
    public Channels getChannelsById(@PathVariable Long id) {
        Optional<Channels> c1 = channelsService.getChannelsById(id);
        return c1.orElse(null);
    }


}
