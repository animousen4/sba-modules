package com.animousen4.authserverwebflux.core.service

import com.animousen4.authserverwebflux.core.dao.UserDao
import com.animousen4.authserverwebflux.core.dto.CreateOrUpdateUserRequest
import com.animousen4.authserverwebflux.core.dto.CreateOrUpdateUserResponse
import com.animousen4.authserverwebflux.core.validator.CreateOrUpdateValidator
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono

@Service
class UserService(
    val userDao: UserDao,
    val createOrUpdateValidator: CreateOrUpdateValidator
) {

    fun createOrUpdateUser(serverRequest: ServerRequest) : Mono<ServerResponse> {

/*
        serverRequest.bodyToMono(CreateOrUpdateUserRequest::class.java).run {
            //userDao.createOrUpdateUser()

            val errors = createOrUpdateValidator.validate(this)

        }*/
        return ServerResponse
            .status(200)
            .body(
                CreateOrUpdateUserResponse(), CreateOrUpdateUserResponse::class.java
            );
    }

}