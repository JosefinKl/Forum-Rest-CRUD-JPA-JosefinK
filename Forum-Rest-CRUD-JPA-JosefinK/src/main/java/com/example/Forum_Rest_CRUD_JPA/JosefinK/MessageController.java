//package com.example.Forum_Rest_CRUD_JPA.JosefinK;
//
//import jakarta.validation.Valid;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/messages")
//public class MessageController {
//    ChannelService channelService;
//    MessageService messageService;
//
//    public MessageController(ChannelService channelService, MessageService messageService) {
//        this.channelService = channelService;
//        this.messageService = messageService;
//    }
//
//    @PutMapping ("/message")
//    public ResponseEntity<Message> updateMessageByID(@Valid @RequestBody Message newMessage) {
//        Message M1 = messageService.updateMessage(newMessage);
//
//        if (M1 != null) {
//            return ResponseEntity.accepted().body(newMessage);
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//
//}
