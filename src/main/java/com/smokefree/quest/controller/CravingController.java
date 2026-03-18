package com.smokefree.quest.controller;

import com.smokefree.quest.model.Craving;
import com.smokefree.quest.repository.CravingRepository;
import com.smokefree.quest.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/player/{playerId}/craving")
public class CravingController {

    @Autowired
    private CravingRepository cravingRepository;

    @Autowired
    private PlayerRepository playerRepository;

    // POST /api/player/{playerId}/craving — log a new craving
    @PostMapping
    public ResponseEntity<Craving> logCraving(@PathVariable Long playerId) {

        if (!playerRepository.existsById(playerId)) {
            return ResponseEntity.notFound().build();
        }

        Craving craving = new Craving();
        craving.setPlayerId(playerId);
        craving.setTimestamp(LocalDateTime.now());
        craving.setDefeated(false);

        Craving saved = cravingRepository.save(craving);
        return ResponseEntity.status(201).body(saved);
    }

    // GET /api/player/{playerId}/craving — get all cravings for a player
    @GetMapping
    public ResponseEntity<List<Craving>> getCravings(@PathVariable Long playerId) {

        if (!playerRepository.existsById(playerId)) {
            return ResponseEntity.notFound().build();
        }

        List<Craving> cravings = cravingRepository.findByPlayerId(playerId);
        return ResponseEntity.ok(cravings);
    }

    @PutMapping("/{cravingId}/defeat")
    public ResponseEntity<Craving> defeatCraving(
        @PathVariable Long playerId,
        @PathVariable Long cravingId){

            if(!playerRepository.existsById(playerId)){
                return ResponseEntity.notFound().build();
            }
            
            return cravingRepository.findById(cravingId)
                .map(craving -> {
                    craving.setDefeated(true);
                    Craving updated = cravingRepository.save(craving);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
        }
}