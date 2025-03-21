package com.torben.webshop.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "person")
data class PersonEntity(
    @Id
    @Column(name = "id")
    var id: Long = 0L,

    @Column(name = "firstname")
    val firstname: String = "",

    @Column(name = "lastname")
    val lastname: String = ""
)