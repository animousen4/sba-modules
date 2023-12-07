package com.animousen4.authserverwebflux.core.dto

import com.animousen4.authserverwebflux.core.dto.UserDto
import org.jetbrains.annotations.NotNull

data class CreateOrUpdateUserRequest(
    val user: UserDto
)
