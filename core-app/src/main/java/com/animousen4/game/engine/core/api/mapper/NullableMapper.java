package com.animousen4.game.engine.core.api.mapper;

public abstract class NullableMapper<FROM, TO> extends Mapper<FROM, TO>{
    @Override
    public TO map(FROM model) throws RuntimeException {
        if (model == null)
            return null;

        return safeMap(model);
    }

    protected abstract TO safeMap(FROM model);
}
