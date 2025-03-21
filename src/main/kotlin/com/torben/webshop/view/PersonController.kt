package com.torben.webshop.view

import com.torben.webshop.service.PersonService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class PersonController(
    private final var personService: PersonService
) {
    @GetMapping("/person")
    fun show(model: Model): String {
        val all = personService.findAll()
        model.addAttribute("persons", all)
        return "person"
    }

    @PostMapping("/person/put")
    fun put(model: Model): String {
        val all = personService.findAll()
        val newestID = all.lastOrNull()?.let {
            it.id +  1
        } as Long? ?: 1

        val firstname = model.getAttribute("firstname") as String
        val lastname = model.getAttribute("lastname") as String

        personService.putPerson(newestID, firstname, lastname)

        return "put"
    }
}