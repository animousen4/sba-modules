package com.animousen4.game.engine.core.repositories.entities;

import com.animousen4.game.engine.core.values.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_roles")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleEntity {
    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;

    @Column(name = "name")
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
}
