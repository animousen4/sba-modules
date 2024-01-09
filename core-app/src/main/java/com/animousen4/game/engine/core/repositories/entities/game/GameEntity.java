package com.animousen4.game.engine.core.repositories.entities.game;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "games")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GameEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "games_generator")
    @SequenceGenerator(name="games_generator", sequenceName = "games_id_seq", allocationSize=1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_status_id", referencedColumnName = "id")
    private GameStatusEntity gameStatus;
}
