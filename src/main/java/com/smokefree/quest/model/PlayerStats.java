package com.smokefree.quest.model;

public class PlayerStats {

    private long minutesFree;
    private double moneySaved;
    private int cigsAvoided;
    private long xp;

    //constructor
    public PlayerStats(long minutesFree, double moneySaved, int cigsAvoided, long xp){
        this.minutesFree = minutesFree;
        this.moneySaved = moneySaved;
        this.cigsAvoided = cigsAvoided;
        this.xp = xp;
    }
    //getters
    public long getMinutesFree(){return minutesFree;}
    public double getMoneySaved(){ return moneySaved;}
    public int getsCigsAVoided(){ return cigsAvoided;}
    public long getXp(){ return xp;}
}
