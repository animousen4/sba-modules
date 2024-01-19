package com.animousen4.game.engine.security;

import com.animousen4.game.engine.core.repositories.UserNamePasswordRepository;
import com.animousen4.game.engine.core.repositories.entities.UserNamePassword;
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

    private final UserNamePasswordRepository userNamePasswordRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading user by username %s".formatted(username));

        UserNamePassword userNamePassword = userNamePasswordRepository.findByUsername(username);

        if (userNamePassword == null)
            throw new UsernameNotFoundException("User not found");

        return User
                .withUsername(userNamePassword.getUsername())
                .password(userNamePassword.getPassword())
                .build();
    }
}
