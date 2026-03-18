package com.smokefree.quest.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity

public class Craving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long playerId;
    private LocalDateTime timestamp;
    private boolean defeated;

    //constructor
    public Craving(){}
    
    public Long getId() { return id; }
    public Long getPlayerId() { return playerId;}
    public LocalDateTime getTimestamp() { return timestamp; }
    public boolean isDefeated() { return defeated;}
    
    public void setId(Long id) { this.id = id;}
    public void setPlayerId( Long playerId) { this.playerId = playerId; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public void setDefeated(boolean defeated) { this.defeated = defeated; }

}

