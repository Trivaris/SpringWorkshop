package com.torben.webshop.view

import com.torben.webshop.service.PersonService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/person")
@Controller
class PersonController(
    private var personService: PersonService
) {
    @GetMapping
    fun show(model: Model, @RequestParam(required = false) error: String?): String {
        val all = personService.findAll()
        model.addAttribute("persons", all)
        model.addAttribute("createForm", PersonCreateForm())

        when (error) {
            "emptyFields" -> model.addAttribute("error", "Please fill out all fields.")
        }

        return "person"
    }

    @PostMapping
    fun put(@ModelAttribute personCreateForm: PersonCreateForm): String {
        val firstname = personCreateForm.firstname
        val lastname = personCreateForm.lastname

        val params = StringBuilder().apply { append("?") }

        if (firstname.isEmpty() || lastname.isEmpty())
            params.append("error=emptyFields")
        else personService.createPerson(firstname, lastname)


        return "redirect:/person$params"
    }
}