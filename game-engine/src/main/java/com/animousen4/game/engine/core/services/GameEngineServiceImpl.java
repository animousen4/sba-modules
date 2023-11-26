package com.animousen4.game.engine.core.services;

import net.andreinc.neatchess.client.UCI;
import net.andreinc.neatchess.client.UCIResponse;
import net.andreinc.neatchess.client.model.Analysis;
import net.andreinc.neatchess.client.model.Move;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
class GameEngineServiceImpl implements GameEngineService{
    UCI uci;

    GameEngineServiceImpl() {
        uci = new UCI();
    }

    public Move getBestSolution(String fen, long moveTime) {
        uci.startStockfish();
        uci.positionFen(fen);
        UCIResponse<Analysis> response = uci.analysis(moveTime);
        var result = response.getResultOrThrow();
        uci.close();
        return result.getBestMove();
    }
}
