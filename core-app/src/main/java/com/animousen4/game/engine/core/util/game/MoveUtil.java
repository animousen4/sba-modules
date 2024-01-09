package com.animousen4.game.engine.core.util.game;

import com.github.bhlangonijr.chesslib.Square;
import com.github.bhlangonijr.chesslib.move.Move;
import org.springframework.stereotype.Component;

@Component
public class MoveUtil {
    public Move getMoveFromString(String from, String to) {
        return new Move(
                Square.fromValue(from.toUpperCase()),
                Square.fromValue(to.toUpperCase())
        );
    }
}
