package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.*;

public class MoveNotLegal extends ErrorPair{
    private MoveNotLegal(List<Placeholder> placeholderList) {
        super(placeholderList);
    }

    public static MoveNotLegal of(String move) {
        return new MoveNotLegal(List.of(
                new Placeholder(MOVE, move)
        ));
    }

    @Override
    public String getErrorCode() {
        return MOVE_NOT_LEGAL;
    }
}
