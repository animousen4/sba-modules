package com.animousen4.game.engine.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.crypto.SecretKey;
import java.security.PublicKey;

@AllArgsConstructor
@Getter
public class JwtPublicKey {
    PublicKey key;
}
