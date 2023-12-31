package com.animousen4.game.engine.core.repositories.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.experimental.WithBy;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@With
@Table(name = "users")
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
