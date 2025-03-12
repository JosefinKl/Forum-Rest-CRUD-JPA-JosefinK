package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelsRepository extends JpaRepository<Channels, Long> {
}
