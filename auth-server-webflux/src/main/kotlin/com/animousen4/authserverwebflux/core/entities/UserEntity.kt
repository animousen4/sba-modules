package com.animousen4.authserverwebflux.core.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table


@Table
data class UserEntity (
    @Id
    val id: Long,
    val username: String,
    val email : String,
    val emailVerified: Boolean,
    @Column("phone_number")
    val phoneNumber: String,
    val avatar: String?
)