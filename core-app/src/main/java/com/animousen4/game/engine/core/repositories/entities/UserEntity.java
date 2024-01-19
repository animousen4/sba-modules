package com.animousen4.game.engine.core.repositories.entities;

import com.animousen4.game.engine.core.repositories.entities.attributes.UserStatusEntity;
import com.animousen4.game.engine.core.values.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.experimental.WithBy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@With
@Table(name = "users")
public class UserEntity implements UserDetails {
    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "users_id_seq")
    Long id;

    String username;

    @Column(name = "registration_date")
    Timestamp registrationDate;

    @Column(name = "close_date")
    Timestamp closeDate;

    @Column(name = "email")
    String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    UserStatusEntity status;

    @Column(name = "password")
    String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_belong_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    List<UserRoleEntity> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return
                roles.stream().map(x -> new SimpleGrantedAuthority(x.getRole().name())).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isNotClosed();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isNotClosed();
    }

    private boolean isNotClosed() {
        return closeDate == null;
    }
}
