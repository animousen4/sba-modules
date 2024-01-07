package com.animousen4.game.engine.core.stateful;

public interface StatefulChessEngine {

    void startNewPosition(String fen, Integer depth, Long maxMoveTime);

    String getBestMove();
}
