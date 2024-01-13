package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Getter
public abstract class ErrorPair{
    abstract public String getErrorCode();

    private final List<Placeholder> placeholderList;

}
