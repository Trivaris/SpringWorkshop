package com.torben.webshop

import com.torben.webshop.model.PersonEntity
import com.torben.webshop.model.PersonRepository
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.Test

//@ShowGeneratedSql
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepositoryTest {
    @Autowired
    lateinit var personRepository: PersonRepository

    @Test
    fun findAll() {
        assertThat(personRepository.findAll()).contains(PersonEntity(1, "Torben", "Joneit"));
    }
}