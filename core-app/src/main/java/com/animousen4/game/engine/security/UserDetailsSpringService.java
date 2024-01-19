package com.animousen4.game.engine.security;

import com.animousen4.game.engine.core.dao.UserDao;
import com.animousen4.game.engine.core.repositories.UserRepository;
import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
@Log4j2
public class UserDetailsSpringService implements UserDetailsService {

    private final UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading user by username %s".formatted(username));

        UserEntity userEntity = userDao.getUserByUsername(username);

        if (userEntity == null)
            throw new UsernameNotFoundException("User not found");

        return userEntity;
    }
}
