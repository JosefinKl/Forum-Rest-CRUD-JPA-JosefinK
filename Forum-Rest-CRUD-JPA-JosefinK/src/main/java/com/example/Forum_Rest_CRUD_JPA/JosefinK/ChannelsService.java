package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelsService {
    @PersistenceContext
    private EntityManager entityManager;

    ChannelsRepository repo;

    public ChannelsService(ChannelsRepository repo) {this.repo = repo; }

    public Channels addChannels(Channels channel) { return repo.save(channel); }

    public List<Channels> getAllChannels() { return repo.findAll(); }

    public Optional<Channels> getChannelsById(Long id) { return repo.findById(id); }

    public Channels updateChannels(Channels newChannel) {
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
