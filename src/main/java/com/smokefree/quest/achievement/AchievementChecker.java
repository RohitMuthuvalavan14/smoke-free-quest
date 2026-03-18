package com.smokefree.quest.achievement;

import java.util.ArrayList;
import java.util.List;

public class AchievementChecker {

    public static List<Achievement> getUnlocked(
           long minutesFree,
           long cravingsDefeated,
           double moneySaved) {
        
        List<Achievement>unlocked = new ArrayList<>();

        if (minutesFree >= 60) unlocked.add(Achievement.FIRST_HOUR);
        if (minutesFree >= 1440) unlocked.add(Achievement.FIRST_DAY);
        if (minutesFree >= 4320)  unlocked.add(Achievement.THREE_DAY);
        if (minutesFree >= 10080) unlocked.add(Achievement.ONE_WEEK);
        if (minutesFree >= 20160) unlocked.add(Achievement.TWO_WEEKS);
        if (minutesFree >= 43200) unlocked.add(Achievement.ONE_MONTH);

        // Craving-based achievements
        if (cravingsDefeated >= 5)  unlocked.add(Achievement.CRAVING_5);
        if (cravingsDefeated >= 20) unlocked.add(Achievement.CRAVING_20);

        // Money-based achievements
        if (moneySaved >= 50)  unlocked.add(Achievement.MONEY_50);
        if (moneySaved >= 200) unlocked.add(Achievement.MONEY_200);

        return unlocked;
    }
}
        
    

