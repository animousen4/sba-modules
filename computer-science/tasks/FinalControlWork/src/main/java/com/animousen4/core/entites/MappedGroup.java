package com.animousen4.core.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class MappedGroup {
    List<Group> groups;
    Map<String, GroupCalcRes> calculatedCommands;
}
