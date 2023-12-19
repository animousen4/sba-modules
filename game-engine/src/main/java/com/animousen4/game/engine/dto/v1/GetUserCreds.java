package com.animousen4.game.engine.dto.v1;

import com.animousen4.game.engine.dto.CoreRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserCreds extends CoreRequest {
    long userId;
}
