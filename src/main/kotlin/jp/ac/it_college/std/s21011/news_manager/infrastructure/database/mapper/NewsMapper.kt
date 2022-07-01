/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper

import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.body
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.categoryId
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.createAt
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.id
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.news
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.publishAt
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.title
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.userId
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.record.News
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.DeleteCompleter
import org.mybatis.dynamic.sql.util.kotlin.KotlinUpdateBuilder
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.UpdateCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.countFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.deleteFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insert
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insertMultiple
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.update
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface NewsMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<News>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="NewsResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        Result(column="publish_at", property="publishAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<News>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("NewsResult")
    fun selectOne(selectStatement: SelectStatementProvider): News?
}

fun NewsMapper.count(completer: CountCompleter) =
    countFrom(this::count, news, completer)

fun NewsMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, news, completer)

fun NewsMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun NewsMapper.insert(row: News) =
    insert(this::insert, row, news) {
        map(id) toProperty "id"
        map(title) toProperty "title"
        map(categoryId) toProperty "categoryId"
        map(publishAt) toProperty "publishAt"
        map(createAt) toProperty "createAt"
        map(userId) toProperty "userId"
        map(body) toProperty "body"
    }

fun NewsMapper.insertMultiple(records: Collection<News>) =
    insertMultiple(this::insertMultiple, records, news) {
        map(id) toProperty "id"
        map(title) toProperty "title"
        map(categoryId) toProperty "categoryId"
        map(publishAt) toProperty "publishAt"
        map(createAt) toProperty "createAt"
        map(userId) toProperty "userId"
        map(body) toProperty "body"
    }

fun NewsMapper.insertMultiple(vararg records: News) =
    insertMultiple(records.toList())

fun NewsMapper.insertSelective(row: News) =
    insert(this::insert, row, news) {
        map(id).toPropertyWhenPresent("id", row::id)
        map(title).toPropertyWhenPresent("title", row::title)
        map(categoryId).toPropertyWhenPresent("categoryId", row::categoryId)
        map(publishAt).toPropertyWhenPresent("publishAt", row::publishAt)
        map(createAt).toPropertyWhenPresent("createAt", row::createAt)
        map(userId).toPropertyWhenPresent("userId", row::userId)
        map(body).toPropertyWhenPresent("body", row::body)
    }

private val columnList = listOf(id, title, categoryId, publishAt, createAt, userId, body)

fun NewsMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, news, completer)

fun NewsMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, news, completer)

fun NewsMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, news, completer)

fun NewsMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun NewsMapper.update(completer: UpdateCompleter) =
    update(this::update, news, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: News) =
    apply {
        set(id) equalToOrNull row::id
        set(title) equalToOrNull row::title
        set(categoryId) equalToOrNull row::categoryId
        set(publishAt) equalToOrNull row::publishAt
        set(createAt) equalToOrNull row::createAt
        set(userId) equalToOrNull row::userId
        set(body) equalToOrNull row::body
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: News) =
    apply {
        set(id) equalToWhenPresent row::id
        set(title) equalToWhenPresent row::title
        set(categoryId) equalToWhenPresent row::categoryId
        set(publishAt) equalToWhenPresent row::publishAt
        set(createAt) equalToWhenPresent row::createAt
        set(userId) equalToWhenPresent row::userId
        set(body) equalToWhenPresent row::body
    }

fun NewsMapper.updateByPrimaryKey(row: News) =
    update {
        set(title) equalToOrNull row::title
        set(categoryId) equalToOrNull row::categoryId
        set(publishAt) equalToOrNull row::publishAt
        set(createAt) equalToOrNull row::createAt
        set(userId) equalToOrNull row::userId
        set(body) equalToOrNull row::body
        where { id isEqualTo row.id!! }
    }

fun NewsMapper.updateByPrimaryKeySelective(row: News) =
    update {
        set(title) equalToWhenPresent row::title
        set(categoryId) equalToWhenPresent row::categoryId
        set(publishAt) equalToWhenPresent row::publishAt
        set(createAt) equalToWhenPresent row::createAt
        set(userId) equalToWhenPresent row::userId
        set(body) equalToWhenPresent row::body
        where { id isEqualTo row.id!! }
    }