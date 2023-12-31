package com.animousen4.game.engine.core.repositories.entities.attributes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "status")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String name;
    String description;
}
