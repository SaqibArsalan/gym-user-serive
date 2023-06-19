package com.gym.user.gymuserservice.service

import com.gym.user.gymuserservice.dto.UserCreationRequestDto
import com.gym.user.gymuserservice.dto.UserDetailsDto
import com.gym.user.gymuserservice.dto.UserUpdateRequestDto
import com.gym.user.gymuserservice.model.User
import com.gym.user.gymuserservice.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

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

    fun getUserById(userId: String): UserDetailsDto {
        val user: Optional<User> = userRepository.findById(userId)

        if (user.isEmpty) {
            throw Exception()
        }

        return UserDetailsDto.toDetails(user.get())
    }

    fun getUserByPhone(userId: String): UserDetailsDto {
        val user: User = userRepository.findByPhoneNumber(userId)

        return UserDetailsDto.toDetails(user)
    }
}