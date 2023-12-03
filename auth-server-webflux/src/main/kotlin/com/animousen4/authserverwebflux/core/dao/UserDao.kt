package com.animousen4.authserverwebflux.core.dao

import com.animousen4.authserverwebflux.core.entities.UserEntity
import com.animousen4.authserverwebflux.core.repo.UserRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Component
class UserDao(

) {
    fun createOrUpdateUser(email : String) : Mono<UserEntity> {
        return Mono.empty()
    }
}