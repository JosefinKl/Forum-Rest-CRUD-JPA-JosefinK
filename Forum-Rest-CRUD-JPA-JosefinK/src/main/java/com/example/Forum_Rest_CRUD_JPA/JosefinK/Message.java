package com.example.Forum_Rest_CRUD_JPA.JosefinK;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="Messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channels channel;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Channels_id", referencedColumnName = "id")
//    private Channels channel;



    public Message() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
