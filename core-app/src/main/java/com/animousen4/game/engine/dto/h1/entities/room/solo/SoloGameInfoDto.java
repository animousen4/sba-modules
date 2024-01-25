package com.animousen4.game.engine.dto.h1.entities.room.solo;

import com.animousen4.game.engine.dto.h1.entities.room.GameDifficultyDto;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SoloGameInfoDto implements Serializable {
    SoloPlayerColorDto color;

    SoloOpponentDto opponent;

    GameDifficultyDto gameDifficulty;
}
