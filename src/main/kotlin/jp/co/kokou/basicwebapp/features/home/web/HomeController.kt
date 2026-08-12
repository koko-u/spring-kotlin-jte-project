package jp.co.kokou.basicwebapp.features.home.web

import jakarta.validation.Valid
import jp.co.kokou.basicwebapp.features.home.dao.MessagesDao
import jp.co.kokou.basicwebapp.features.home.dto.NameDto
import jp.co.kokou.basicwebapp.features.home.viewmodel.IndexPage
import jp.co.kokou.basicwebapp.features.home.viewmodel.toIndexErrors
import jp.co.kokou.basicwebapp.shared.viewmodel.Page
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class HomeController(
    val dao: MessagesDao,
) {
    @GetMapping
    fun index(): ModelAndView {
        val home = Page().copy(currentMenu = "home")
        return ModelAndView("pages/index", "page", IndexPage(home))
    }

    @PostMapping
    fun post(
        @Valid @ModelAttribute nameDto: NameDto,
        bindingResult: BindingResult,
    ): ModelAndView {
        if (bindingResult.hasErrors()) {
            val home = Page().copy(currentMenu = "home")
            val errors = bindingResult.toIndexErrors()
            return ModelAndView("pages/index", "page", IndexPage(errors, home))
        }

        dao.insertMessage(nameDto.name)

        return ModelAndView("redirect:/response")
    }
}
