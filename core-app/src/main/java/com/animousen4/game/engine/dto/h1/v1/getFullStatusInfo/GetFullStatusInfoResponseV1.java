package com.animousen4.game.engine.dto.h1.v1.getFullStatusInfo;

import com.animousen4.game.engine.core.api.dto.StatusInfoDto;
import com.animousen4.game.engine.dto.h1.CoreResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class GetFullStatusInfoResponseV1 extends CoreResponse {

    StatusInfoDto statusInfo;

}
