package com.gym.user.gymuserservice.Controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.gym.user.gymuserservice.controller.UserController
import com.gym.user.gymuserservice.dto.UserCreationRequestDto
import com.gym.user.gymuserservice.service.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.whenever
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

@ExtendWith(MockitoExtension::class)
class ControllerTest: BaseControllerTest() {

    @Mock
    private lateinit var userService: UserService

    private lateinit var mockMvc: MockMvc

    private val objectMapper: ObjectMapper = ObjectMapper()

    companion object {
        const val BASE_URI = "/v1/user"
    }

    @BeforeEach
    fun beforeEach(documentationContextProvider: RestDocumentationContextProvider) {
        mockMvc = super.configureMockMvcFor(
            UserController(userService),
            documentationContextProvider
        )
    }

    @Nested
    inner class UserCreation {
        private val userCreationDto = UserCreationRequestDto("name", "03311231231", "email-address", "password", "active")

        @Test
        fun shouldSuccess() {
            doNothing().whenever(
                userService).addUser(userCreationDto)

            val andReturn = mockMvc.perform(
                MockMvcRequestBuilders.post(BASE_URI)
                    .content(
                        objectMapper.writeValueAsString(
                            userCreationDto
                        )
                    )
                    .contentType(MediaType.APPLICATION_JSON)
            ).andReturn()

            Mockito.verify(userService, Mockito.times(1))
                .addUser(userCreationDto)


            Assertions.assertEquals(HttpStatus.OK.value(), andReturn.response.status)
        }
    }

}