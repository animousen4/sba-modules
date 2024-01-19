package com.animousen4.game.engine.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.security.PrivateKey;

@AllArgsConstructor
@Getter
public class JwtPrivateKey {
    PrivateKey key;
}
