package com.torben.webshop

import com.torben.webshop.service.PersonService
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import kotlin.test.Test

//@ShowGeneratedSql
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepositoryTest {
    @Autowired
    @MockitoBean
    private lateinit var personService: PersonService

    @Test
    fun findAll() {
        assertThat(personService.findAll()).isInstanceOfAny(List::class.java)
    }
}