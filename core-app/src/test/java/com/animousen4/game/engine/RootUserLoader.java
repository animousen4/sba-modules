package com.animousen4.game.engine;

import com.animousen4.game.engine.core.api.command.SignInCommand;
import com.animousen4.game.engine.core.api.result.JwtResult;
import com.animousen4.game.engine.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RootUserLoader {
    private final AuthenticationService authenticationService;

    @Value("${user.root.username}")
    String username;


    @Value("${user.root.password}")
    String password;
    public JwtResult getRootUserJwt() {
        return authenticationService.signIn(
                SignInCommand.builder()
                        .username(username)
                        .password(password)
                        .build()
        );
    }
}
