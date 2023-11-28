package com.animousen4.authserverwebflux.core.service

import com.animousen4.authserverwebflux.core.dto.UserDto
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Service
class UserService {
    suspend fun createOrUpdateUser(serverRequest: ServerRequest) : ServerResponse =
        ok().buildAndAwait();

}