package jp.ac.it_college.std.s21011.news_manager.application.service

import jp.ac.it_college.std.s21011.news_manager.domain.model.NewsWithCategory
import jp.ac.it_college.std.s21011.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(
    private val newsRepository: NewsRepository
) {
    fun getList(): List<NewsWithCategory> {
        return newsRepository.findAllWithCategory()
    }
    fun getDetail(newsId: Long): NewsWithCategory {
        return newsRepository.findWithCategory(newsId) ?: throw IllegalArgumentException("存在しないID: $newsId")
    }
}