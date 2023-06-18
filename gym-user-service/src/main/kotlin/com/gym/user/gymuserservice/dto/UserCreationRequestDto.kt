package com.gym.user.gymuserservice.dto

import com.devskiller.friendly_id.FriendlyId
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.gym.user.gymuserservice.model.User

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserCreationRequestDto(
    var fullName: String,
    var phoneNumber: String,
    var emailAddress: String,
    var password: String,
    var accountStatus: String
) {
    companion object {
        fun toUser(user: UserCreationRequestDto): User {
            return User(
                fullName = user.fullName,
                phoneNumber = user.phoneNumber,
                emailAddress = user.emailAddress,
                password= user.password,
                accountStatus = user.accountStatus
            )
        }

    }

}