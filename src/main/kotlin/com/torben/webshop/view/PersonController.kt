package com.torben.webshop.view

import com.torben.webshop.service.PersonService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

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

}