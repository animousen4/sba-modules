package com.animousen4.authserverwebflux.core.repo

import com.animousen4.authserverwebflux.core.entities.UserEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface UserRepository : R2dbcRepository<UserEntity, Long> {
    fun getUserEntityByEmail(email: String) : Mono<UserEntity>;

}