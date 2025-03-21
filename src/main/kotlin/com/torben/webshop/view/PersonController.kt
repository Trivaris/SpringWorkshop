package com.torben.webshop.view

import com.torben.webshop.service.PersonService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/person")
@Controller
class PersonController(
    private final var personService: PersonService
) {
    @GetMapping
    fun show(model: Model): String {
        val all = personService.findAll()
        model.addAttribute("persons", all)
        model.addAttribute("createForm", PersonCreateForm("", ""))
        return "person"
    }

    @PostMapping
    fun put(@ModelAttribute personCreateForm: PersonCreateForm) {

        val firstname = personCreateForm.firstname
        val lastname = personCreateForm.lastname

        personService.createPerson(firstname, lastname)
    }
}