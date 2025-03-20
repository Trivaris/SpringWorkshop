package com.torben.webshop

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class UsersController {

    @GetMapping("/users")
    fun show(): String {
        return "users"
    }

}