package com.torben.webshop.service

import com.torben.webshop.model.PersonEntity
import com.torben.webshop.model.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
    private final var personRepository: PersonRepository
) {
    fun findAll()  = personRepository.findAll()
    fun putPerson(id: Long, firstname: String, lastname: String) = personRepository.save(PersonEntity(id, firstname, lastname))
}