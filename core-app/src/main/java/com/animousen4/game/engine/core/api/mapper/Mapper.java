package com.animousen4.game.engine.core.api.mapper;

public interface Mapper<FROM, TO>{
    TO map(FROM model);
}
