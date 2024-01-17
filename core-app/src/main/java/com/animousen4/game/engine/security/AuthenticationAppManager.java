package com.animousen4.game.engine.security;

import com.animousen4.game.engine.core.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Log4j2
@RequiredArgsConstructor
public class AuthenticationAppManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        authentication.setAuthenticated(true);
        log.info(authentication);
        return authentication;
    }
}
