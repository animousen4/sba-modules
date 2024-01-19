package com.animousen4.game.engine.core.underwriting;

import com.animousen4.game.engine.core.api.command.SignInCommand;
import com.animousen4.game.engine.core.api.command.SignUpCommand;
import com.animousen4.game.engine.core.api.dto.user.UserDto;
import com.animousen4.game.engine.core.api.result.JwtResult;
import com.animousen4.game.engine.core.dao.UserDao;
import com.animousen4.game.engine.core.repositories.UserRepository;
import com.animousen4.game.engine.core.repositories.entities.UserEntity;
import com.animousen4.game.engine.core.services.factory.UserEntityFactory;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.core.validate.description.UserExists;
import com.animousen4.game.engine.core.values.UserStatus;
import com.animousen4.game.engine.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SignUpUnderwritingImpl implements SignUpUnderwriting{

    private final UserDao userDao;

    private final UserEntityFactory userEntityFactory;

    private final UserDetailsService userDetailsService;

    private final ValidationErrorFactory validationErrorFactory;

    private final SignInUnderwriting signInUnderwriting;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    @Override
    public JwtResult signUpUser(SignUpCommand signUpCommand) {
        //UserDetails user = userDetailsService.loadUserByUsername(signUpCommand.getUser().getUsername());

        UserDetails user = userDao.getUserByUsername(signUpCommand.getUser().getUsername());

        if (user != null)
            return failSignUpUserExists(signUpCommand);


        return successSignUp(signUpCommand);
    }

    public JwtResult failSignUpUserExists(SignUpCommand signUpCommand) {
        return JwtResult.builder()
                .validationErrors(List.of(
                        validationErrorFactory.buildError(
                                UserExists.of(signUpCommand.getUser().getUsername())
                        )
                ))
                .build();
    }

    public JwtResult successSignUp(SignUpCommand signUpCommand) {

        UserDto userDto = signUpCommand.getUser();
        UserDetails details = userDao.saveOrUpdateUser(
                userEntityFactory.createNewUser(
                        userDto.getUsername(),
                        userDto.getEmail(),
                        passwordEncoder.encode(userDto.getPassword()),
                        UserStatus.OK
                )
        );

        return JwtResult.builder()
                .jwt(jwtService.generateToken(details))
                .build();
    }
}
