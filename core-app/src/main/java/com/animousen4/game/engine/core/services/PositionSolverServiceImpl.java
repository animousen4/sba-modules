package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.api.command.SolvePositionCommand;
import com.animousen4.game.engine.core.api.result.SolvePositionResult;
import com.animousen4.game.engine.core.stateful.StatefulChessEngine;
import com.animousen4.game.engine.core.stateful.StatefulChessEngineFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
class PositionSolverServiceImpl implements PositionSolverService {

    @Autowired
    private StatefulChessEngineFactory chessEngineFactory;

    private final Map<String, StatefulChessEngine> engines = new HashMap<>();
    @Override
    public SolvePositionResult solvePosition(SolvePositionCommand command) {
        if (!engines.containsKey(command.getFenPosition())) {
            StatefulChessEngine engine = chessEngineFactory.createChessEngineInstance();
            engine.startNewPosition(command.getFenPosition(), command.getDepth(), command.getDuration());
            engines.put(command.getFenPosition(), engine);
        }

        return SolvePositionResult.builder()
                .bestMove(engines.get(command.getFenPosition()).getBestMove())
                .build();

    }

}
