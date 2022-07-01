/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object CategoryDynamicSqlSupport {
    val category = Category()

    val id = category.id

    val name = category.name

    class Category : AliasableSqlTable<Category>("category", ::Category) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val name = column<String>(name = "name", jdbcType = JDBCType.VARCHAR)
    }
}