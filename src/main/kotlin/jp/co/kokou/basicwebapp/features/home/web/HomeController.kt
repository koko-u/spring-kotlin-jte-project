package jp.co.kokou.basicwebapp.features.home.web

import jp.co.kokou.basicwebapp.shared.viewmodel.Page
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class HomeController {
    @GetMapping
    fun index(): ModelAndView =
        ModelAndView("pages/index", "page", Page().copy(currentMenu = "home"))
}
