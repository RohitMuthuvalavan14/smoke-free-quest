package com.smokefree.quest.repository;

import com.smokefree.quest.model.Craving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CravingRepository extends JpaRepository<Craving, Long> {

    List<Craving> findByPlayerId(Long playerId);

    long countByPlayerIdAndDefeated(Long playerId, boolean defeated);

}
