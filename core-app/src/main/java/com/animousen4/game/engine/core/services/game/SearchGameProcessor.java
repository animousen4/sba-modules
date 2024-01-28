package com.animousen4.game.engine.core.services.game;

import java.util.List;
public interface SearchGameProcessor<T>{
    void pushToQueue(QueuedGame<T> game);

    List<QueuedGame<T>> getGames();

}
