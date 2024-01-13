package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.*;

public class UserNotFound extends ErrorPair{
    private UserNotFound(List<Placeholder> placeholderList) {
        super(placeholderList);
    }

    public static UserNotFound of(String username) {
        return new UserNotFound(List.of(
                new Placeholder(USERNAME, username)
        ));
    }

    @Override
    public String getErrorCode() {
        return USER_NOT_FOUND;
    }
}
