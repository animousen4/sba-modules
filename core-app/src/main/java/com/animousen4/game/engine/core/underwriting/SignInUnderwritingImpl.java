package com.animousen4.game.engine.core.underwriting;

import com.animousen4.game.engine.core.api.command.SignInCommand;
import com.animousen4.game.engine.core.api.result.JwtResult;
import com.animousen4.game.engine.core.dao.UserDao;
import com.animousen4.game.engine.core.repositories.UserNamePasswordRepository;
import com.animousen4.game.engine.core.repositories.entities.UserNamePassword;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.core.validate.description.InvalidLoginOrPassword;
import com.animousen4.game.engine.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SignInUnderwritingImpl implements SignInUnderwriting{

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private final JwtService jwtService;

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    private final UserNamePasswordRepository userNamePasswordRepository;

    private final ValidationErrorFactory validationErrorFactory;

    @Override
    public JwtResult authenticateUser(SignInCommand command) {

        //UserNamePassword userNamePassword = userNamePasswordRepository.findByUsername(command.getUsername());
        UserDetails userDetails = userDetailsService.loadUserByUsername(command.getUsername());
        if (userDetails != null &&
                passwordEncoder.matches(command.getPassword(), userDetails.getPassword())
        )
            return buildAuthenticatedResponse(command);

        return buildInvalidPasswordAuthenticationResponse(command);
    }

    private JwtResult buildAuthenticatedResponse(SignInCommand command) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                command.getUsername(),
                command.getPassword()
        ));

        var user = userDetailsService
                .loadUserByUsername(command.getUsername());

        var jwt = jwtService.generateToken(user);

        return JwtResult.builder()
                .jwt(jwt)
                .build();
    }

    private JwtResult buildInvalidPasswordAuthenticationResponse(SignInCommand command) {
        return JwtResult.builder()
                .validationErrors(List.of(validationErrorFactory.buildError(
                        InvalidLoginOrPassword.of()
                )))
                .build();
    }

}
