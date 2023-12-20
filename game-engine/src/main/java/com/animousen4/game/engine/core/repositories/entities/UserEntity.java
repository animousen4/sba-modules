package com.animousen4.game.engine.core.repositories.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder

@Table(name = "users", schema = "user_schema")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    String username;

    @Column(name = "registration_date")
    Timestamp registrationDate;

    @Column(name = "close_date")
    Timestamp closeDate;

    String email;

    @Column(name = "status_id")
    Long statusId;

    @Column(name = "status_reason_id")
    Long statusReasonId;

    @Column(name = "creator_id")
    long creatorId;

}
