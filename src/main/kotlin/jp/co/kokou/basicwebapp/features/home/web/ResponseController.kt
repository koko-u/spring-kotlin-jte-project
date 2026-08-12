package jp.co.kokou.basicwebapp.features.home.web

import jp.co.kokou.basicwebapp.features.home.dao.MessagesDao
import jp.co.kokou.basicwebapp.features.home.viewmodel.MessagePage
import jp.co.kokou.basicwebapp.shared.viewmodel.Page
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/response")
class ResponseController(
    val dao: MessagesDao,
) {
    @GetMapping
    fun get(
        @RequestParam message: String?,
    ): ModelAndView {
        val message = dao.selectLastMessage()

        return ModelAndView(
            "pages/message",
            "page",
            MessagePage(
                message = message ?: "Good Morning",
                Page(currentMenu = "home", title = "Response Page"),
            ),
        )
    }
}
