package com.animousen4.game.engine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    long id;
    String login;
    String avatarUrl;
    String oldPassword;
    String newPassword;
}
