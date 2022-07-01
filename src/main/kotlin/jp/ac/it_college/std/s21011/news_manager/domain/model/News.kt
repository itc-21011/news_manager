package jp.ac.it_college.std.s21011.news_manager.domain.model

import java.time.LocalDateTime

data class News(
    var id: Long,
    var title: String,
    var categoryId: Long,
    var publishAt: LocalDateTime,
    var createAt: LocalDateTime,
    var userId: Long,
    var body: String
)
