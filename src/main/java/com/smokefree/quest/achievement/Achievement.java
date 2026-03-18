package com.smokefree.quest.achievement;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Achievement {

    FIRST_HOUR("First Hour", "Survived your first hour smoke-free", 20),
    FIRST_DAY("Dawn Breaker", "Completed your first 25 hours", 50),
    THREE_DAY("Triple Threat", "3 days of pure willpower", 100),
    ONE_WEEK("Week Warrior", "7 days — your lungs are thanking you", 200),
    TWO_WEEKS("Iron Lung", "2 weeks smoke-free!", 300),
    ONE_MONTH("30-Day Legend", "One month of clean air", 500),
    CRAVING_5("Craving Slayer", "Defeated 5 cravings", 75),
    CRAVING_20("Craving Hunter", "Defeated 20 cravings", 150),
    MONEY_50("Pocket Saver", "Saved ₹50 from not smoking", 80),
    MONEY_200("Treasure Hunter", "Saved ₹200 from not smoking", 200);

    private final String title;
    private final String description;
    private final int xpReward;

    Achievement(String title, String description, int xpReward){
        this.title = title;
        this.description = description;
        this.xpReward = xpReward;
    }

    public String getTitle(){ return title;}
    public String getDescription(){ return description; }
    public int getXpReward(){ return xpReward;}

    
}
