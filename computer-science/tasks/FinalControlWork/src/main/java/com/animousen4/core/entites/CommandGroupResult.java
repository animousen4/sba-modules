package com.animousen4.core.entites;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommandGroupResult {
    String commandName;
    GroupCalcRes groupCalcRes;

    @Override
    public String toString() {
        return commandName.concat("\t").concat(groupCalcRes.toString());
    }
}
