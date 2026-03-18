package com.smokefree.quest.controller;

import com.smokefree.quest.achievement.Achievement;
import com.smokefree.quest.achievement.AchievementChecker;
import com.smokefree.quest.model.Player;
import com.smokefree.quest.model.PlayerStats;
import com.smokefree.quest.repository.CravingRepository;
import com.smokefree.quest.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CravingRepository cravingRepository;

    // POST /api/player
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        player.setQuitDate(LocalDateTime.now());
        Player saved = playerRepository.save(player);
        return ResponseEntity.status(201).body(saved);
    }

    // GET /api/player/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        return playerRepository.findById(id)
            .map(player -> ResponseEntity.ok(player))
            .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/player/{id}/stats
    @GetMapping("/{id}/stats")
    public ResponseEntity<PlayerStats> getStats(@PathVariable Long id) {
        return playerRepository.findById(id)
            .map(player -> {
                long minutesFree = java.time.Duration.between(
                    player.getQuitDate(),
                    java.time.LocalDateTime.now()
                ).toMinutes();

                double cigsPerMinute = (double) player.getCigsPerDay() / (24 * 60);
                double moneySaved = minutesFree * cigsPerMinute
                    * (player.getPricePerPack() / player.getCigsPerPack());
                moneySaved = Math.round(moneySaved * 100.0) / 100.0;

                int cigsAvoided = (int)(minutesFree * cigsPerMinute);
                long xp = minutesFree + (cigsAvoided * 10L);

                PlayerStats stats = new PlayerStats(minutesFree, moneySaved, cigsAvoided, xp);
                return ResponseEntity.ok(stats);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/player/{id}/achievements
    @GetMapping("/{id}/achievements")
    public ResponseEntity<List<Achievement>> getAchievements(@PathVariable Long id) {
        return playerRepository.findById(id)
            .map(player -> {
                long minutesFree = java.time.Duration.between(
                    player.getQuitDate(),
                    java.time.LocalDateTime.now()
                ).toMinutes();

                long cravingsDefeated = cravingRepository
                    .countByPlayerIdAndDefeated(id, true);

                double cigsPerMinute = (double) player.getCigsPerDay() / (24 * 60);
                double moneySaved = minutesFree * cigsPerMinute
                    * (player.getPricePerPack() / player.getCigsPerPack());

                List<Achievement> unlocked = AchievementChecker.getUnlocked(
                    minutesFree, cravingsDefeated, moneySaved
                );

                return ResponseEntity.ok(unlocked);
            })
            .orElse(ResponseEntity.notFound().build());
    }
}