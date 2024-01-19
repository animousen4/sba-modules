package com.animousen4.game.engine.security.service;

import com.animousen4.game.engine.core.api.command.SignInCommand;
import com.animousen4.game.engine.core.api.command.SignUpCommand;
import com.animousen4.game.engine.core.api.dto.user.UserDto;
import com.animousen4.game.engine.core.api.result.JwtResult;
import com.animousen4.game.engine.core.dao.UserDao;
import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.services.factory.UserEntityFactory;
import com.animousen4.game.engine.core.underwriting.SignInUnderwriting;
import com.animousen4.game.engine.core.validate.validator.SignInExistValidator;
import com.animousen4.game.engine.core.validate.validator.SignInMandatoryValidator;
import com.animousen4.game.engine.core.values.UserStatus;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserDetailsService userDetailsService;
    private final UserDao userDao;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserEntityFactory userEntityFactory;
    private final SignInMandatoryValidator signInMandatoryValidator;
    private final SignInExistValidator signInExistValidator;

    private final SignInUnderwriting signInUnderwriting;

    public JwtResult signUp(SignUpCommand request) {

        // creating user;
        UserDto userDto = request.getUserDto();

        UserEntity ent = userDao.saveOrUpdateUser(
                userEntityFactory.createNewUser(
                        userDto.getUsername(),
                        userDto.getEmail(),
                        userDto.getPassword(),
                        UserStatus.OK
                )
        );

        var jwt = jwtService.generateToken(ent);
        return JwtResult.builder()
                .jwt(jwt)
                .build();
    }

    public JwtResult signIn(SignInCommand request) {
        log.info(request.getUsername() + " | " + request.getPassword());

        List<ValidationError> errors = signInMandatoryValidator.validate(request);

        if (errors.isEmpty()) {
            return signInUnderwriting.authenticateUser(request);
        }
        return JwtResult.builder()
                .validationErrors(errors)
                .build();
    }


}