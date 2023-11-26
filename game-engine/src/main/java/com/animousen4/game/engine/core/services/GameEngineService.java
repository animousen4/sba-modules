package com.animousen4.game.engine.core.services;

import net.andreinc.neatchess.client.model.Move;

public interface GameEngineService {
    public Move getBestSolution(String fen, long moveTime);
}
