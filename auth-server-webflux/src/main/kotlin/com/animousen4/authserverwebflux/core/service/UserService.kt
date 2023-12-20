package com.animousen4.authserverwebflux.core.service

import com.animousen4.authserverwebflux.core.dao.UserDao
import com.animousen4.authserverwebflux.core.validator.CreateOrUpdateValidator
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.*

@Service
class UserService(
    val userDao: UserDao,
    val createOrUpdateValidator: CreateOrUpdateValidator
) {

    suspend fun getUserInfo(serverRequest: ServerRequest) : ServerResponse {
        val user = userDao.getUserByEmail("bot@animousen4.me")

        return ServerResponse.ok().buildAndAwait()

    }

}