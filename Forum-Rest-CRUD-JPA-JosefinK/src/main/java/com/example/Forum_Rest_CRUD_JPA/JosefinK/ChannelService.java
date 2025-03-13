package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {
    @PersistenceContext
    private EntityManager entityManager;

    ChannelRepository repo;

    public ChannelService(ChannelRepository repo) {this.repo = repo; }

    public Channel addChannel(Channel channel) { return repo.save(channel); }

    public List<Channel> getAllChannels() { return repo.findAll(); }

    public Optional<Channel> getChannelsById(Long id) { return repo.findById(id); }

    public Channel updateChannels(Channel newChannel) {
        return repo.findById(newChannel.getId()).map(Channels ->{
            Channels.setName(newChannel.getName());
            Channels.setDescription(newChannel.getDescription());

            return repo.save(Channels);
        }).orElse(null);

    }

    public void deleteChannels(long id) {
        repo.deleteById(id);
    }
}
