package com.gym.user.gymuserservice.dto

import com.devskiller.friendly_id.FriendlyId
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.gym.user.gymuserservice.model.User
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserUpdateRequestDto(
    val fullName: String,
    val phoneNumber: String,
    val emailAddress: String,
    val password: String,
    val accountStatus: String
) {
    companion object {
        fun toUser(user: UserUpdateRequestDto, userId: String): User {
            return User(
                fullName = user.fullName,
                phoneNumber = user.phoneNumber,
                emailAddress = user.emailAddress,
                password= user.password,
                accountStatus = user.accountStatus
            ).apply {
                this.id = userId
            }
        }

    }

}