package com.animousen4.game.engine.core.validations.regex;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidationRegex {
    public final Pattern usernameSizeRegex = Pattern.compile(".{3,18}");
    public final Pattern usernameSymbolsRegex = Pattern.compile("([A-Z]|[a-z]|[0-9])*");

    public final Pattern mailRegex = Pattern.compile("^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$");
}
