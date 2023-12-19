package com.animousen4.game.engine.core.repositories.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;

@Entity
@Getter
@Table(name = "users", schema = "user_schema")
public class UserEntity {
    @Id
    long id;

    String username;

    @Column(name = "registration_date")
    Timestamp registrationDate;

    @Column(name = "close_date")
    Timestamp closeDate;

    String email;

    @Column(name = "status_id")
    long statusId;

    @Column(name = "status_reason_id")
    long statusReasonId;

    @Column(name = "creator_id")
    long creatorId;

}
