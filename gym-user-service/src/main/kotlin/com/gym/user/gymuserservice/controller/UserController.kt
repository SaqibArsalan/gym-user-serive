package com.gym.user.gymuserservice.controller

import com.gym.user.gymuserservice.dto.UserCreationRequestDto
import com.gym.user.gymuserservice.dto.UserUpdateRequestDto
import com.gym.user.gymuserservice.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/user")
class UserController(val userService: UserService) {

    @PostMapping
    fun addUser(@RequestBody user: UserCreationRequestDto) = userService.addUser(user)

    @PutMapping("/{userId}")
    fun updateUser(@RequestBody user: UserUpdateRequestDto, @PathVariable userId: String) = userService.updateUser(user, userId)


}