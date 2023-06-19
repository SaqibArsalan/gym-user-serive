package com.gym.user.gymuserservice.dto

import com.gym.user.gymuserservice.model.User


data class UserDetailsDto(
    val userId: String,
    val fullName: String,
    val phoneNumber: String,
    val emailAddress: String,
    val accountStatus: String
) {
    companion object {
        fun toDetails(user: User): UserDetailsDto {
            return UserDetailsDto(
                userId = user.id!!,
                fullName = user.fullName,
                phoneNumber = user.phoneNumber,
                emailAddress = user.emailAddress,
                accountStatus = user.accountStatus
            )
        }
    }
}