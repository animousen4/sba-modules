package com.animousen4.core.entites;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Match {
    String commandOne;
    int goalOne;

    String commandTwo;
    int goalTwo;

    public boolean isDraw() {
        return goalOne == goalTwo;
    }

    public boolean winOne() {
        return goalOne > goalTwo;
    }

    public boolean winTwo() {
        return goalOne < goalTwo;
    }
}
