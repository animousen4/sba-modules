package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.*;

public class StatusNotFound extends ErrorPair{
    private StatusNotFound(List<Placeholder> placeholderList) {
        super(placeholderList);
    }

    public static StatusNotFound of(Long statusId) {
        return new StatusNotFound(List.of(
                new Placeholder(STATUS_ID, statusId)
        ));
    }

    @Override
    public String getErrorCode() {
        return STATUS_NOT_FOUND;
    }
}
