package com.animousen4.game.engine.dto.h1.v1.getUserInfo;

import com.animousen4.game.engine.dto.h1.CoreRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserInfoRequestV1 extends CoreRequest {
    private String username;
}
