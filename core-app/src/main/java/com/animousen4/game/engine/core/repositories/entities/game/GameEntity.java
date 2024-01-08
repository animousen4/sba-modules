package com.animousen4.game.engine.core.repositories.entities.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Getter
@RedisHash("game")
public class GameEntity implements Serializable {
    private Long id;
}
