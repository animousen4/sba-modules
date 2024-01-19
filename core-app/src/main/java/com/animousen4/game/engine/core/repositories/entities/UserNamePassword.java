package com.animousen4.game.engine.core.repositories.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "users")
@Entity
@Getter
public class UserNamePassword {
    @Id
    Long id;

    String username;

    String password;
}
