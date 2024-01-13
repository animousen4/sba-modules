package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.USERNAME;
import static com.animousen4.game.engine.core.values.AppConsts.USERNAME_LENGTH_PROBLEM;

public class UsernameLengthProblem extends ErrorPair{
    private UsernameLengthProblem(List<Placeholder> placeholderList) {
        super(placeholderList);
    }

    public static UsernameLengthProblem of(String username) {
        return new UsernameLengthProblem(List.of(
                new Placeholder(USERNAME, username)
        ));
    }

    @Override
    public String getErrorCode() {
        return USERNAME_LENGTH_PROBLEM;
    }
}
