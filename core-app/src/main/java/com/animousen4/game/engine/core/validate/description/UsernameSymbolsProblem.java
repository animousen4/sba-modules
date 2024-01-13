package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.*;

public class UsernameSymbolsProblem extends ErrorPair{
    private UsernameSymbolsProblem(List<Placeholder> placeholderList) {
        super(placeholderList);
    }

    public static UsernameSymbolsProblem of(String username) {
        return new UsernameSymbolsProblem(List.of(
                new Placeholder(USERNAME, username)
        ));
    }

    @Override
    public String getErrorCode() {
        return USERNAME_SYMBOLS_PROBLEM;
    }
}
