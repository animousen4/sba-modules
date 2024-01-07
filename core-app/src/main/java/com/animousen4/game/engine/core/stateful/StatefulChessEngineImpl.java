package com.animousen4.game.engine.core.stateful;

import com.animousen4.game.engine.logger.StatefulGameEngineLogger;
import net.andreinc.neatchess.client.UCI;
import net.andreinc.neatchess.client.UCIResponse;
import net.andreinc.neatchess.client.model.Analysis;

public class StatefulChessEngineImpl implements StatefulChessEngine{
    private final UCI uci;
    private UCIResponse<Analysis> response;

    private final StatefulGameEngineLogger gameEngineLogger;

    StatefulChessEngineImpl(String enginePath, StatefulGameEngineLogger logger) {
        uci = new UCI();
        uci.start(enginePath);
        gameEngineLogger = logger;
        gameEngineLogger.logStartup();
    }

    @Override
    public void startNewPosition(String fen, Integer depth, Long maxMoveTime) {
        gameEngineLogger.logNewFenPosition(fen);
        uci.positionFen(fen);
        //uci.bestMove(depth, maxMoveTime);
        response = uci.analysis(maxMoveTime);
    }

    @Override
    public String getBestMove() {
        gameEngineLogger.logStatus(response.toString());
        return response.getResult().getAllMoves().toString();
    }
}
