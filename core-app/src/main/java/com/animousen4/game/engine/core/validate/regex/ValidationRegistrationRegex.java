package com.animousen4.game.engine.core.validate.regex;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ValidationRegistrationRegex {
    public final String usernameSizeRegex = ".{3,18}";
    public final String usernameSymbolsRegex = "([A-Z]|[a-z]|[0-9])*";

    public final String mailRegex = "([A-Z]|[a-z]|[0-9])+@([A-Z]|[a-z]|[0-9])+\\.([A-Z]|[a-z]|[0-9])+";

}
