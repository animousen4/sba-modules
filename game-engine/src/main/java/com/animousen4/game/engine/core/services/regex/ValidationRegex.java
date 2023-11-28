package com.animousen4.game.engine.core.services.regex;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidationRegex {
    public final String usernameSizeRegex = ".{3,18}";
    public final String usernameSymbolsRegex = "([A-Z]|[a-z]|[0-9])*";

    public final String mailRegex = "([A-Z]|[a-z]|[0-9])+@([A-Z]|[a-z]|[0-9])+\\.([A-Z]|[a-z]|[0-9])+";
}
