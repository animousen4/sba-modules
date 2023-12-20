package com.animousen4.game.engine.core.underwriting.engine;

import net.andreinc.neatchess.client.UCI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@Service
public class EngineStartupService {

    @Value("game.engine.stockfish")
    String enginePath;

    public UCI getNewEngineInstance() {
        URL resource = EngineStartupService.class.getResource(enginePath);
        UCI uci = new UCI();
        try {
            assert resource != null;
            String path = Paths.get(resource.toURI()).toFile().getAbsolutePath();
            uci.start(path);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return uci;
    }
}
