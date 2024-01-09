package com.animousen4.game.engine.core.repositories.entities.game;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "games")
@Getter
public class GameEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "games_generator")
    @SequenceGenerator(name="games_generator", sequenceName = "games_id_seq", allocationSize=1)
    private Long id;

    @Column(name = "game_status_id")
    private Long gameStatusId;
}
