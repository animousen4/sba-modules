package com.animousen4.authserverwebflux.core.repo

import com.animousen4.authserverwebflux.core.entities.UserEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface UserRepository : ReactiveCrudRepository<UserEntity, Long>{

}