package com.gym.user.gymuserservice.service

import com.gym.user.gymuserservice.dto.UserCreationRequestDto
import com.gym.user.gymuserservice.dto.UserUpdateRequestDto
import com.gym.user.gymuserservice.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun addUser(user: UserCreationRequestDto) {
        userRepository.save(UserCreationRequestDto.toUser(user))
    }

    fun updateUser(updateUser: UserUpdateRequestDto, userId: String) {
        val user = userRepository.findById(userId)

        if (user.isEmpty) {
            throw Exception()
        }
        userRepository.save(UserUpdateRequestDto.toUser(updateUser, userId))
    }
}