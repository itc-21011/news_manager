package jp.ac.it_college.std.s21011.news_manager.application.service

import jp.ac.it_college.std.s21011.news_manager.domain.model.News
import jp.ac.it_college.std.s21011.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminNewsService(
    private val newsRepository: NewsRepository
) {
    @Transactional
    fun register(news: News) {
        newsRepository.findWithCategory(news.id)?.let {
            throw IllegalArgumentException("すでに存在するID: ${news.id}")
        }
        newsRepository.register(news)
    }

    @Transactional
    fun delete(newsId: Long) {
        newsRepository.findWithCategory(newsId) ?: throw IllegalArgumentException("存在しないID: $newsId")
        newsRepository.delete(newsId)
    }
}