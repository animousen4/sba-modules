package com.animousen4.authserverwebflux.core.service

import com.animousen4.authserverwebflux.core.validator.CreateOrUpdateValidator
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.*

@Service
class UserService(
    val createOrUpdateValidator: CreateOrUpdateValidator
) {

    suspend fun getUserInfo(serverRequest: ServerRequest) : ServerResponse {

        return ServerResponse.ok().buildAndAwait()

    }

}