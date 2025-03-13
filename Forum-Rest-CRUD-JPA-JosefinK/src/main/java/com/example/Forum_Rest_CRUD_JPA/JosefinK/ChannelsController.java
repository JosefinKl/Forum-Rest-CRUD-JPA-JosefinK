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
    MessageService messageService;


    public ChannelsController(ChannelsService channelsService, MessageService messageService) {
        this.channelsService = channelsService;
        this.messageService = messageService;
    }


    @PostMapping
    public ResponseEntity<Channels> createChannelsByResponseBody(@Valid @RequestBody Channels channels) {

        Channels c1 = channelsService.addChannels(channels);
        return ResponseEntity.ok(c1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> createMessage(@PathVariable Long id, @Valid @RequestBody Message message) {
        message.channelId = id;
        Message m1 = messageService.addMessage(message);
        if (m1 != null) {
            return ResponseEntity.accepted().body(m1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<Message>>
    getMessageByChannelId(@PathVariable Long id) {
        List<Message> messages = messageService.getAllMessages(id);
        if (messages.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(messages);
        }
    }



// Update Channel, not in scope
//    @PutMapping
//    public ResponseEntity<Channels> updateChannelsById(@Valid @RequestBody Channels newChannels) throws Exception {
//        Channels c1 = channelsService.updateChannels(newChannels);
//
//        if(c1 != null) {
//            return ResponseEntity.accepted().body(newChannels);
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }

//    @GetMapping("/{id}")
//    public Channels getChannelsById(@PathVariable Long id) {
//        Optional<Channels> c1 = channelsService.getChannelsById(id);
//        return c1.orElse(null);
//    }

    @GetMapping
    public List<Channels> getAllChannels() {
        return channelsService.getAllChannels();

    }

    @DeleteMapping("/{id}")
    public void deleteChannelsById(@PathVariable Long id){
        channelsService.deleteChannels(id);
    }


}