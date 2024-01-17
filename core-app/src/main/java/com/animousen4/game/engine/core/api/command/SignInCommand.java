package com.animousen4.game.engine.core.api.command;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
@Builder
@Getter
public class SignInCommand {
    String username;
    String password;
}
