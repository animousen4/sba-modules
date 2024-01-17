package com.animousen4.game.engine.security.service;

import com.animousen4.game.engine.core.api.command.SignInCommand;
import com.animousen4.game.engine.core.api.command.SignUpCommand;
import com.animousen4.game.engine.core.api.dto.user.UserDto;
import com.animousen4.game.engine.core.api.result.JwtResult;
import com.animousen4.game.engine.core.dao.UserDao;
import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserDetailsService userDetailsService;
    private final UserDao userDao;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public JwtResult signUp(SignUpCommand request) {

        // creating user;
        UserDto userDto = request.getUserDto();
        UserEntity ent = userDao.saveOrUpdateUser(
                userDao.saveOrUpdateUser(
                        UserEntity.builder()
                                .email(userDto.getEmail())
                                .username(userDto.getUsername())
                                .statusReasonId(1L)
                                .statusId(1L)
                                .build()
                )
        );
        var jwt = jwtService.generateToken(ent);
        return JwtResult.builder()
                .jwt(jwt)
                .build();
    }

    public JwtResult signIn(SignInCommand request) {
        log.info(request.getUsername() + " " + request.getPassword());

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = userDetailsService
                .loadUserByUsername(request.getUsername());

        var jwt = jwtService.generateToken(user);
        return JwtResult.builder()
                .jwt(jwt)
                .build();
    }
}