package com.animousen4.game.engine.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.crypto.SecretKey;
import java.security.Key;

@AllArgsConstructor
@Getter
public class JwtSecretKey {
    SecretKey key;
}
