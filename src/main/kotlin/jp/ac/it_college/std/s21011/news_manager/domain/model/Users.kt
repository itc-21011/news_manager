package jp.ac.it_college.std.s21011.news_manager.domain.model

import jp.ac.it_college.std.s21011.news_manager.domain.enum.RoleType

data class Users(
    var id: Long,
    var username: String,
    var password: String,
    var viewName: String,
    var roleType: RoleType,
)
