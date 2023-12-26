package com.animousen4.core.entites;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Group {
    String groupName;
    List<String> commands;
}
