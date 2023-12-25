package com.animousen4.game.engine.dto.v1.getUserInfo;

import com.animousen4.game.engine.dto.CoreRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserInfoRequestV1 extends CoreRequest {
    Long userId;
}
