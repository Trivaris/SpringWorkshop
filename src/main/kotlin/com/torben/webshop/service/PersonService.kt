package com.torben.webshop.service

import com.torben.webshop.model.PersonEntity
import com.torben.webshop.model.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
    private var personRepository: PersonRepository
) {
    val latestID: Long
        get() {
            val all = findAll()
            return if (all.isEmpty()) 0 else all.maxOf { it.id } + 1
        }

    fun findAll()  = personRepository.findAll()

    fun createPerson(firstname: String, lastname: String) {
        val person = PersonEntity(
            id= latestID,
            firstname = firstname,
            lastname = lastname
        )
        personRepository.save(person)
    }
}