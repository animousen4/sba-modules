package com.animousen4.game.engine.core.repositories.entities.attributes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "status_reason", schema = "user_schema")
public class StatusReasonEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String name;
    String description;

    @Column(name = "status_id")
    Long statusId;
}
