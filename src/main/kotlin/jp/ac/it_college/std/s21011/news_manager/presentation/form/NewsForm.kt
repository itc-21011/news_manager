package jp.ac.it_college.std.s21011.news_manager.presentation.form

import jp.ac.it_college.std.s21011.news_manager.domain.model.Category
import jp.ac.it_college.std.s21011.news_manager.domain.model.NewsWithCategory
import java.time.LocalDateTime

data class GetNewsListResponse(val newsList: List<NewsInfo>)

data class NewsInfo(
    val id: Long,
    val title: String,
    val categoryId: Long,
    val userId: Long,
    val body: String,
    val isCategory: Boolean
) {
    constructor(model: NewsWithCategory) : this
        (model.news.id, model.news.title, model.news.categoryId, model.news.userId, model.news.body, model.isCategory
    )
}

data class GetNewsDetailResponse(
    val id: Long,
    val title: String,
    val categoryId: Long,
    val publishAt: LocalDateTime,
    val createAt: LocalDateTime,
    val userId: Long,
    val body: String,
    val categoryInfo: CategoryInfo?
) {
    constructor(model: NewsWithCategory) : this(
        model.news.id,
        model.news.title,
        model.news.categoryId,
        model.news.publishAt,
        model.news.createAt,
        model.news.userId,
        model.news.body,
        model.category?.let { CategoryInfo(model.category) }
    )
}

data class CategoryInfo(
    val id: Long,
    val name: String,
) {
    constructor(category: Category) : this(
        category.id,
        category.name,
    )
}

data class RegisterNewsRequest(
    val id: Long,
    val title: String,
    val categoryId: Long,
    val publishAt: LocalDateTime,
    val createAt: LocalDateTime,
    val userId: Long,
    val body: String,
)