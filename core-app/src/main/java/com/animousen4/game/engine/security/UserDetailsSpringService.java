package com.animousen4.game.engine.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Log4j2
public class UserDetailsSpringService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading user by username %s".formatted(username));
        if (username.equals("admin"))
            return User
                    .withUsername("admin")
                    .password(
                            passwordEncoder.encode("admin")
                    )
                    .build();
        throw new UsernameNotFoundException("User not found");
    }
}
