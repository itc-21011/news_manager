package jp.ac.it_college.std.s21011.news_manager.presentation.controller

import jp.ac.it_college.std.s21011.news_manager.application.service.AdminNewsService
import jp.ac.it_college.std.s21011.news_manager.domain.model.News
import jp.ac.it_college.std.s21011.news_manager.presentation.form.RegisterNewsRequest
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("admin/news")
@CrossOrigin(origins = ["http://localhost:8081/"], allowCredentials = "true")
class AdminNewsController(
    private val adminNewsService: AdminNewsService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterNewsRequest) {
        adminNewsService.register(
            News(request.id, request.title, request.categoryId, request.publishAt, request.createAt, request.userId, request.body)
        )
    }

    @DeleteMapping("/delete/{news_id}")
    fun delete(@PathVariable("news_id") newsId: Long) {
        adminNewsService.delete(newsId)
    }
}