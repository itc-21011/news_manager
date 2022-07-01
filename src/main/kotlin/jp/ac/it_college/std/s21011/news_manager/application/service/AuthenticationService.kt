package jp.ac.it_college.std.s21011.news_manager.application.service

import jp.ac.it_college.std.s21011.news_manager.domain.model.Users
import jp.ac.it_college.std.s21011.news_manager.domain.repository.UsersRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(private val usersRepository: UsersRepository) {
    fun findUsers(user: String): Users? {
        return usersRepository.find(user)
    }
}