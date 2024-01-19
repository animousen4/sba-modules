package com.animousen4.game.engine.security.config;
import com.animousen4.game.engine.core.dao.UserDao;
import com.animousen4.game.engine.core.repositories.UserNamePasswordRepository;
import com.animousen4.game.engine.security.JwtPrivateKey;
import com.animousen4.game.engine.security.JwtPublicKey;
import com.animousen4.game.engine.security.UserDetailsSpringService;
import com.animousen4.game.engine.security.filter.JwtAuthenticationFilter;
import com.animousen4.game.engine.security.service.JwtService;

import lombok.RequiredArgsConstructor;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    @Value("classpath:${jwt.secret.public}")
    private Resource rsaPublicKey;

    @Value("classpath:${jwt.secret.private}")
    private Resource rsaPrivateKey;


    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter (JwtService jwtService, UserDetailsService userDetailsService) {
        return new JwtAuthenticationFilter(jwtService, userDetailsService);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    UserDetailsService userDetailsService(UserDao userDao) {
        return new UserDetailsSpringService(userDao);
    }

    @Bean
    AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

        return daoAuthenticationProvider;

    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager manager, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                        authorizationManagerRequestMatcherRegistry
                                .requestMatchers("/api/v1/user/getUserInfo").hasAuthority("USER")
                                .requestMatchers("/internal/api/v1/auth/**").permitAll()
                                .anyRequest().authenticated())
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationManager(manager)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    KeyFactory keyFactoryRsa() throws NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        return KeyFactory.getInstance("RSA");
    }
    @Bean
    JwtPrivateKey jwtSecretKey(KeyFactory kf) throws InvalidKeySpecException, IOException {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(
                Base64.getDecoder().decode(
                        rsaPrivateKey.getContentAsString(Charset.defaultCharset())
                                .replace("-----BEGIN RSA PRIVATE KEY-----", "")
                                .replaceAll(System.lineSeparator(), "")
                                .replace("-----END RSA PRIVATE KEY-----", "")
                )
        );
        PrivateKey privKey = kf.generatePrivate(keySpec);

        return new JwtPrivateKey(privKey);
    }

    @Bean
    JwtPublicKey jwtPublicKey(KeyFactory kf) throws InvalidKeySpecException, IOException {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(
                Base64.getDecoder().decode(
                        rsaPublicKey.getContentAsString(Charset.defaultCharset())
                                .replace("-----BEGIN PUBLIC KEY-----", "")
                                .replaceAll(System.lineSeparator(), "")
                                .replace("-----END PUBLIC KEY-----", "")
                )
        );
        PublicKey publicKey = kf.generatePublic(keySpec);

        return new JwtPublicKey(publicKey);
    }


}
