package com.gym.user.gymuserservice.repository

import com.gym.user.gymuserservice.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface UserRepository: JpaRepository<User, String> {
}