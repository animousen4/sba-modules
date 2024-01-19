package com.animousen4.game.engine.core.api.result;

import com.animousen4.game.engine.dto.h1.CoreRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class JwtResult extends CoreResult{
    String jwt;
}
