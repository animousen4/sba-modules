package com.animousen4.game.engine.core.repositories.entities.attributes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_status_reason")
public class StatusReasonEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "status_reason_generator")
    @SequenceGenerator(name="status_reason_generator", sequenceName = "status_reason_id_seq", allocationSize=1)
    Long id;
    String name;

    @Column(name = "status_id")
    Long statusId;
}
