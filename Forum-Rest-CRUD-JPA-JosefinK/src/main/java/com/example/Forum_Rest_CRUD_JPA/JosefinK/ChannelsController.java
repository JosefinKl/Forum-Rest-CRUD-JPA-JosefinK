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
@RequestMapping("/channels")
public class ChannelsController {

    ChannelsService channelsService;

    List<Channel> channels = new ArrayList<>();



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

    @GetMapping("/{id}")
    public Channels getChannelsById(@PathVariable Long id) {
        Optional<Channels> c1 = channelsService.getChannelsById(id);
        return c1.orElse(null);
    }

    @GetMapping
    public List<Channels> getAllChannels() {
        return channelsService.getAllChannels();

    }

    @DeleteMapping("/{id}")
    public void deleteChannelsById(@PathVariable Long id){
        channelsService.deleteChannels(id);
    }


}
