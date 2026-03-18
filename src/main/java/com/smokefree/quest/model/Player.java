package com.smokefree.quest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity

public class Player {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime quitDate;
    private int cigsPerDay;
    private double pricePerPack;
    private int cigsPerPack;

    public Player(){}

    public Long getId() { return id;}
    public String getName(){ return name;}
    public LocalDateTime getQuitDate() {return quitDate;}
    public int getCigsPerDay(){ return cigsPerDay;}
    public double getPricePerPack(){ return pricePerPack;}
    public int getCigsPerPack(){ return cigsPerPack;}

    public void  setId(Long id) {  this.id = id;}
    public void  setName(String name){ this.name=name;}
    public void  setQuitDate(LocalDateTime quitDate) {this.quitDate = quitDate;}
    public void  setCigsPerDay(int cigsPerDay){ this.cigsPerDay = cigsPerDay;}
    public void  setPricePerPack(double pricePerPack){ this.pricePerPack=pricePerPack;}
    public void  setCigsPerPack(int cigsPerPack){ this.cigsPerPack = cigsPerPack;}

    }

