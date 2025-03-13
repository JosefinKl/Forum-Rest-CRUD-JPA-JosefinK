package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages(long channelId) {
        return messageRepository.findAllByChannelId(channelId);
    }


//    public List<Message> getMessagesByChannelId(long channelId) {
//        return messageRepository.findByChannelId(channelId);
//    }

}
