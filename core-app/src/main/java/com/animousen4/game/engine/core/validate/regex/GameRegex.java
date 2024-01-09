package com.animousen4.game.engine.core.validate.regex;

import org.springframework.stereotype.Component;

@Component
public class GameRegex {
    public final String moveRegex = "([A-H]|[a-h])[1-8]";
}
