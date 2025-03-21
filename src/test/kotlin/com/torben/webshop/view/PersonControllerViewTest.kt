package com.torben.webshop.view

import com.torben.webshop.model.PersonEntity
import com.torben.webshop.service.PersonService
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.*
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest

import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.model
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

private const val ENDPOINT = "/person"

@WebMvcTest(PersonController::class)
@TestPropertySource(properties = ["logging.level.org.springframework.web=DEBUG"])
class PersonControllerViewTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockitoBean
    private lateinit var personService: PersonService

    @Test
    fun shouldShow() {
        // given
        given(personService.findAll()).willReturn(
            listOf(
                PersonEntity(1, "Torben", "Joneit"),
                PersonEntity(2, "Fachher", "Syed")
            )
        )

        // when
        val result = mockMvc.perform(get(ENDPOINT))

        // then
        result.andExpect{
            status().isOk()
            model().attributeExists("persons")
            model().attribute("persons", listOf(
                PersonEntity(1, "Torben", "Joneit"),
                PersonEntity(2, "Fachher", "Syed")
            ))
        }
    }

    @Test
    fun shouldPut() {
        // when
        mockMvc.perform(post(ENDPOINT).param("firstname", "Hans").param("lastname", "Meiser"))

        // then
        verify(personService).createPerson("Hans", "Meiser")
    }

    @Test
    fun shouldError() {
        // when
        val result = mockMvc.perform(post(ENDPOINT).param("firstname", "").param("lastname", ""))

        // then
        result.andExpect {
            status().isOk
            model().attributeExists("error", "emptyFields")
        }
    }
}