package com.animousen4.game.engine.core.api.mapper;

public interface ModelDtoMapper<MODEL, DTO> {
    DTO map(MODEL model);
}
