package com.animousen4.authserverwebflux.core.validator

data class ValidationError(
    val field: String,
    val description: String
)
