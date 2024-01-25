package com.animousen4.game.engine.core.services.room;

import com.animousen4.game.engine.core.api.command.SoloGameSearchCommand;
import com.animousen4.game.engine.core.api.result.SoloGameSearchResult;

public interface SoloRoomService {
    SoloGameSearchResult searchSoloGame(SoloGameSearchCommand command);
}
