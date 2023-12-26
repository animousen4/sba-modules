package com.animousen4.core.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class GroupCalcRes {
    public int points;
    public int wins;
    public int draws;
    public int loses;

    public int scored;
    public int missed;

    @Override
    public String toString() {
        return String.valueOf(points).concat("\t")
                .concat(String.valueOf(wins)).concat("\t")
                .concat(String.valueOf(draws)).concat("\t")
                .concat(String.valueOf(loses)).concat("\t")
                .concat(String.valueOf(scored)).concat("\t")
                .concat(String.valueOf(missed)).concat(" ");
    }
}
