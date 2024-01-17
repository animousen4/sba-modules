package com.animousen4.game.engine.core.api.command;

import com.animousen4.game.engine.core.api.dto.user.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SignUpCommand extends CoreCommand{
    UserDto userDto;
}
