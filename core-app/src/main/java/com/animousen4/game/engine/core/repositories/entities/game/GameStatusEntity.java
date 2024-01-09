package com.animousen4.game.engine.core.repositories.entities.game;

import com.animousen4.game.engine.core.values.GameStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "game_status")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GameStatusEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "game_status_generator")
    @SequenceGenerator(name="game_status_generator", sequenceName = "game_status_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private GameStatus name;
}
