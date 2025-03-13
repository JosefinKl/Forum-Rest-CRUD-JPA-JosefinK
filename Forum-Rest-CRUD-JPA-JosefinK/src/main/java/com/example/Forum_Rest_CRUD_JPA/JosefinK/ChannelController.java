package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    ChannelService channelService;
    MessageService messageService;


    public ChannelController(ChannelService channelService, MessageService messageService) {
        this.channelService = channelService;
        this.messageService = messageService;
    }


    @PostMapping
    public ResponseEntity<Channel> createChannelsByResponseBody(@Valid @RequestBody Channel channel) {

        Channel c1 = channelService.addChannel(channel);
        return ResponseEntity.ok(c1);
    }

    @PostMapping("/message/{id}")
    public ResponseEntity<Message> createMessage(@PathVariable long id, @Valid @RequestBody Message message) {
        Channel c = channelService.getChannelsById(id).orElse(null);
        message.setChannel(c);
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

    @GetMapping
    public List<Channel> getAllChannels() {
        var t = channelService.getAllChannels();
        return t;
    }

    @DeleteMapping("/{id}")
    public void deleteChannelsById(@PathVariable Long id){
        channelService.deleteChannels(id);
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




}