package com.gym.user.gymuserservice.controller

import com.gym.user.gymuserservice.dto.UserCreationRequestDto
import com.gym.user.gymuserservice.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
class UserController(val userService: UserService) {

    @PostMapping
    fun addUser(@RequestBody user: UserCreationRequestDto) = userService.addUser(user)


}