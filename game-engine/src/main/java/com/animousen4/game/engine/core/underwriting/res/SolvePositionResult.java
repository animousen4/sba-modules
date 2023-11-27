package com.animousen4.game.engine.core.underwriting.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SolvePositionResult {
    String bestMove;
    List<String> bestVariant;
}
