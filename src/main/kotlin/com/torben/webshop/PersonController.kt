package com.torben.webshop

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PersonController {

    @GetMapping("/person")
    fun show(): String {
        return "person"
    }

}