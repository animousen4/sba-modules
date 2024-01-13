package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.*;

public class UserExists extends ErrorPair{
    private UserExists(List<Placeholder> placeholderList) {
        super(placeholderList);
    }

    public static UserExists of(String username) {
        return new UserExists(List.of(
                new Placeholder(USERNAME, username)
        ));
    }

    @Override
    public String getErrorCode() {
        return USER_EXISTS;
    }
}
