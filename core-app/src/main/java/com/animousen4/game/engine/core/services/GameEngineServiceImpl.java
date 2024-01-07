package com.animousen4.game.engine.core.services;

import net.andreinc.neatchess.client.UCI;
import net.andreinc.neatchess.client.UCIResponse;
import net.andreinc.neatchess.client.model.Analysis;
import net.andreinc.neatchess.client.model.Move;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@Service
class GameEngineServiceImpl implements GameEngineService{
    UCI uci;

    public Move getBestSolution(String fen, long moveTime) {
        uci.positionFen(fen);
        UCIResponse<Analysis> response = uci.analysis(moveTime);
        var result = response.getResultOrThrow();
        uci.close();
        return result.getBestMove();
    }
}
