package com.animousen4.game.engine.core.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StatusInfoDto {
    String statusName;
    String statusDescription;

}
