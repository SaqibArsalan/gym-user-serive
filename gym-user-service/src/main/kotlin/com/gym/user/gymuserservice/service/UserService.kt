package com.gym.user.gymuserservice.service

import com.gym.user.gymuserservice.dto.UserCreationRequestDto
import com.gym.user.gymuserservice.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun addUser(user: UserCreationRequestDto) {
        userRepository.save(UserCreationRequestDto.toUser(user))
    }
}