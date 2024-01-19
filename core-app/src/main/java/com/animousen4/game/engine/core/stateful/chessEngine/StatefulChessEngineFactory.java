package com.animousen4.game.engine.core.stateful.chessEngine;

import com.animousen4.game.engine.logger.StatefulGameEngineLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@Component
public class StatefulChessEngineFactory {
    @Value("${game.engine.stockfish}")
    String enginePath;

    @Autowired
    StatefulGameEngineLogger logger;
    public StatefulChessEngine createChessEngineInstance() {
        URL resource = StatefulChessEngineFactory.class.getResource(enginePath);
        try {
            String path = Paths.get(resource.toURI()).toFile().getAbsolutePath();
            return new StatefulChessEngineImpl(path, logger);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
