package com.animousen4.authserverwebflux.core.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.Date


@Table
data class UserEntity (
    @Id
    val id: Long,
    val username: String,
    val registrationDate: Date,
    val closeDate: Date,
    val email: String,
    val statusId: Long,
    val statusReasonId: Long,
    val creatorId: Long
)