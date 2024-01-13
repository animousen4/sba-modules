package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.*;

public class InvalidMoveFormat extends ErrorPair{
    private InvalidMoveFormat(List<Placeholder> placeholderList) {
        super(placeholderList);
    }

    public static InvalidMoveFormat of(String move) {
        return new InvalidMoveFormat(List.of(
                new Placeholder(MOVE, move)
        ));
    }

    @Override
    public String getErrorCode() {
        return INVALID_MOVE_FORMAT;
    }
}
