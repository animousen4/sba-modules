package com.animousen4.authserverwebflux.core.dto


data class UserDto(
    val id: Long,
    val userName: String,
    val password: String
)
