package com.animousen4.game.engine.core.services.game;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class QueuedGame<T> {
    QueuedGameStatus status;
    private final RequiredGame requiredGame;
    List<Place> satisfiedPlaces;
    Date addDate;
    T game;
}
