package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.*;

public class GameNotExists extends ErrorPair{
    private GameNotExists(List<Placeholder> placeholderList) {
        super(placeholderList);
    }

    public static GameNotExists of(Long id) {
        return new GameNotExists(List.of(
                new Placeholder(GAME_ID, id)
        ));
    }

    @Override
    public String getErrorCode() {
        return GAME_NOT_EXISTS;
    }
}
