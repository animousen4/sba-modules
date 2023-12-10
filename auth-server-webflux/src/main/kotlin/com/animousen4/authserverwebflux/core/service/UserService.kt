package com.animousen4.authserverwebflux.core.service

import com.animousen4.authserverwebflux.core.dao.UserDao
import com.animousen4.authserverwebflux.core.validator.CreateOrUpdateValidator
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono

@Service
class UserService(
    val userDao: UserDao,
    val createOrUpdateValidator: CreateOrUpdateValidator
) {

    fun getUser(serverRequest: ServerRequest) : Mono<ServerResponse> {
        val user = userDao.getUserByEmail("bot@animousen4.me");

        return ServerResponse
            .status(200)
            .body(user);
    }

}