/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper

import java.sql.JDBCType
import jp.ac.it_college.std.s21011.news_manager.domain.enum.RoleType
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object UsersDynamicSqlSupport {
    val users = Users()

    val id = users.id

    val username = users.username

    val password = users.password

    val viewName = users.viewName

    val roleType = users.roleType

    class Users : AliasableSqlTable<Users>("users", ::Users) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val username = column<String>(name = "username", jdbcType = JDBCType.VARCHAR)

        val password = column<String>(name = "password", jdbcType = JDBCType.VARCHAR)

        val viewName = column<String>(name = "view_name", jdbcType = JDBCType.VARCHAR)

        val roleType = column<RoleType>(name = "role_type", jdbcType = JDBCType.CHAR, typeHandler = "org.apache.ibatis.type.EnumTypeHandler")
    }
}