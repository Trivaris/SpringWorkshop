package com.torben.webshop.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PersonRepository : JpaRepository<PersonEntity, Long> {
    fun findByLastname(lastname: String): Optional<PersonEntity>
}