package com.animousen4.game.engine.core.services.room;

import com.animousen4.game.engine.core.api.command.SoloGameSearchCommand;
import com.animousen4.game.engine.core.api.result.SoloGameSearchResult;
import org.springframework.stereotype.Service;

@Service
public class SoloRoomServiceImpl implements SoloRoomService{
    @Override
    public SoloGameSearchResult searchSoloGame(SoloGameSearchCommand command) {
        return ;
    }
}
