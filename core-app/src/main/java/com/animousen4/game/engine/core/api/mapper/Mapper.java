package com.animousen4.game.engine.core.api.mapper;

public abstract class Mapper<FROM, TO>{
    public abstract TO map(FROM model);
}
