package com.animousen4.authserverwebflux.core.dto

import com.animousen4.authserverwebflux.core.dto.UserDto

data class CreateOrUpdateUserRequest(
    val userDto: UserDto
)
