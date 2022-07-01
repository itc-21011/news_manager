package jp.ac.it_college.std.s21011.news_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21011.news_manager.domain.model.Category
import jp.ac.it_college.std.s21011.news_manager.domain.model.News
import jp.ac.it_college.std.s21011.news_manager.domain.model.NewsWithCategory
import jp.ac.it_college.std.s21011.news_manager.domain.repository.NewsRepository
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.*
import org.springframework.stereotype.Repository
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.record.News as RecordNews
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.record.NewsWithCategory as RecordNewsWithCategory

@Repository
class NewsRepositoryImpl(
    private val newsWithCategoryMapper: NewsWithCategoryMapper,
    private val newsMapper: NewsMapper
) : NewsRepository {
    override fun findAllWithCategory(): List<NewsWithCategory> {
        return newsWithCategoryMapper.select{ }.map { toModel(it) }
    }

    override fun findWithCategory(id: Long): NewsWithCategory? {
        return newsWithCategoryMapper.selectByPrimaryKey(id) {
        }?.let { toModel(it) }
    }

    override fun register(news: News) {
        newsMapper.insert(toRecord(news))
    }

    override fun delete(id: Long) {
        newsMapper.deleteByPrimaryKey(id)
    }

    private fun toModel(record: RecordNewsWithCategory): NewsWithCategory {
        val news = News(
            record.id!!,
            record.title!!,
            record.categoryId!!,
            record.publishAt!!,
            record.createAt!!,
            record.userId!!,
            record.body!!,
        )
        val category = record.id?.let {
            Category(
                record.id!!,
                record.name!!
            )
        }
        return NewsWithCategory(news, category)
    }

    private fun toRecord(model: News): RecordNews {
        return RecordNews(model.id, model.title, model.categoryId, model.publishAt, model.createAt, model.userId, model.body)
    }
}