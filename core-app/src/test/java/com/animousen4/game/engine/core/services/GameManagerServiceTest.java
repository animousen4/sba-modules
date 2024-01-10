package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.repositories.GameRepository;
import com.animousen4.game.engine.core.repositories.redis.CurrentGameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameManagerServiceTest {

    @Mock
    GameRepository gameRepository;

    @Mock
    GameModelFactory gameModelFactory;

    @Mock
    CurrentGameRepository currentGameRepository;

    @InjectMocks
    GameManagerServiceImpl gameManagerService;

    @Test
    void testValidResponse() {

    }
}
