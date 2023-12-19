package com.animousen4.game.engine.core.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Placeholder {
    public Placeholder(String placeholderName, long i) {
        this.placeholderName = placeholderName;
        this.placeholderValue = String.valueOf(i);
    }
    private String placeholderName;

    private String placeholderValue;
}
