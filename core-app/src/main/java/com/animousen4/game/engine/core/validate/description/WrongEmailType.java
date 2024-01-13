package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.USERNAME_LENGTH_PROBLEM;
import static com.animousen4.game.engine.core.values.AppConsts.WRONG_EMAIL_TYPE;

public class WrongEmailType extends ErrorPair{
    private WrongEmailType(List<Placeholder> placeholderList) {
        super(placeholderList);
    }

    public static WrongEmailType of(String username) {
        return new WrongEmailType(List.of(
                new Placeholder(WRONG_EMAIL_TYPE, username)
        ));
    }

    @Override
    public String getErrorCode() {
        return WRONG_EMAIL_TYPE;
    }
}
