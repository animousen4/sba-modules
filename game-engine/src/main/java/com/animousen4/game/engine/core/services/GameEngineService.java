package com.animousen4.game.engine.core.services;

import net.andreinc.neatchess.client.model.Move;

public interface GameEngineService {
    Move getBestSolution(String fen, long moveTime);
}
