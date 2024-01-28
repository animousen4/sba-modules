package com.animousen4.game.engine.core.services.game;

import com.animousen4.game.engine.core.api.model.game.GameGenreModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class RequiredGame {
    private final GameGenreModel gameGenre;
    private final List<Place> places;
}
