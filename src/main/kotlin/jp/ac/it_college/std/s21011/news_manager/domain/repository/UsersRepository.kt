package jp.ac.it_college.std.s21011.news_manager.domain.repository

import jp.ac.it_college.std.s21011.news_manager.domain.model.Users

interface UsersRepository {
    fun find(user: String): Users?
}