package com.animousen4.game.engine.dto.v1;

import com.animousen4.game.engine.core.api.dto.FullStatusInfoDto;
import com.animousen4.game.engine.dto.CoreResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class GetFullStatusInfoResponseV1 extends CoreResponse {

    FullStatusInfoDto fullStatusInfo;

}
