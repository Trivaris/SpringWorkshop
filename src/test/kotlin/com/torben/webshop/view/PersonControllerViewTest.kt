package com.torben.webshop.view

import com.torben.webshop.model.PersonEntity
import com.torben.webshop.service.PersonService
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito.*
import org.mockito.Mockito
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
    private lateinit var personService: PersonService;

    @Test
    fun shouldShow() {
        // given
        given(personService.findAll()).willReturn(
            listOf(
                PersonEntity(1, "Torben", "Joneit"),
                PersonEntity(2, "Fachher", "Syed")
            )
        );

        // when
        val result = mockMvc.perform(get(ENDPOINT))

        // then
        result.andExpect(status().isOk())
        result.andExpect(model().attributeExists("persons"))
        // TODO: Test for user given by mock
    }

    @Test
    fun shouldPut() {
        // when
        mockMvc.perform(post(ENDPOINT).param("firstname", "Hans").param("lastname", "Meiser"));

        // then
        Mockito.verify(personService).createPerson("Hans", "Meiser");
    }
}