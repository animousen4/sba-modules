package com.animousen4.game.engine.core.repositories.entities.attributes;

import com.animousen4.game.engine.core.values.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_status")
public class UserStatusEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "user_status_generator")
    @SequenceGenerator(name="user_status_generator", sequenceName = "user_status_id_seq", allocationSize = 1)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    UserStatus status;
}
