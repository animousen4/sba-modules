package com.animousen4.game.engine.core.api.model.game.board;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Duration;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class BoardSide {

    ChessClock chessClock;

    List<Piece> takenPieces;
}
