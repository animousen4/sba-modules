package com.animousen4.game.engine.core.api.model.game;

import lombok.Builder;
import lombok.Getter;

import java.time.Duration;

@Getter
@Builder
public class GameInfo {
    Long whiteUser;
    Long blackUser;

    Long duration;
}
