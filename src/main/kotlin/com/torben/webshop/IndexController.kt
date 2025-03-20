package com.torben.webshop

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @GetMapping("", "/")
    fun show(): String {
        return "forward:/index.html"
    }

}