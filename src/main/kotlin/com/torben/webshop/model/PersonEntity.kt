package com.torben.webshop.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
data class PersonEntity (
    @Id
    @Column(name = "id")
    var id: Long,

    @Column(name = "firstname")
    private val firstname: String,

    @Column(name = "lastname")
    private val lastname: String
)