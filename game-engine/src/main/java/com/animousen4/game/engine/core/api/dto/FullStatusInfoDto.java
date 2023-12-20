package com.animousen4.game.engine.core.api.dto;

import lombok.Builder;

@Builder
public class FullStatusInfoDto {
    String statusName;
    String statusDescription;

    String statusNameReason;
    String statusNameDescription;
}
