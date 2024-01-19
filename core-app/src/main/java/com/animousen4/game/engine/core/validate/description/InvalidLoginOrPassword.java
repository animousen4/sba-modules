package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.*;

public class InvalidLoginOrPassword extends ErrorPair{
    private InvalidLoginOrPassword(List<Placeholder> placeholderList) {
        super(placeholderList);
    }

    public static InvalidLoginOrPassword of() {
        return new InvalidLoginOrPassword(List.of());
    }

    @Override
    public String getErrorCode() {
        return INVALID_LOGIN_OR_PASSWORD;
    }
}
