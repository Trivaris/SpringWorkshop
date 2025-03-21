package com.torben.webshop.service

import com.torben.webshop.model.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
    private var personRepository: PersonRepository
) {
    fun findAll()  = personRepository.findAll()
    // TODO: Fix
//    fun createPerson(firstname: String, lastname: String) = personRepository.save(PersonEntity(firstname, lastname))
    fun createPerson(firstname: String, lastname: String) {}
}