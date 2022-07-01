/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper

import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.id
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.password
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.roleType
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.username
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.users
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport.viewName
import jp.ac.it_college.std.s21011.news_manager.infrastructure.database.record.Users
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.EnumTypeHandler
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
interface UsersMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Users>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="UsersResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        Result(column="view_name", property="viewName", jdbcType=JdbcType.VARCHAR),
        Result(column="role_type", property="roleType", typeHandler=EnumTypeHandler::class, jdbcType=JdbcType.CHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Users>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("UsersResult")
    fun selectOne(selectStatement: SelectStatementProvider): Users?
}

fun UsersMapper.count(completer: CountCompleter) =
    countFrom(this::count, users, completer)

fun UsersMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, users, completer)

fun UsersMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun UsersMapper.insert(row: Users) =
    insert(this::insert, row, users) {
        map(id) toProperty "id"
        map(username) toProperty "username"
        map(password) toProperty "password"
        map(viewName) toProperty "viewName"
        map(roleType) toProperty "roleType"
    }

fun UsersMapper.insertMultiple(records: Collection<Users>) =
    insertMultiple(this::insertMultiple, records, users) {
        map(id) toProperty "id"
        map(username) toProperty "username"
        map(password) toProperty "password"
        map(viewName) toProperty "viewName"
        map(roleType) toProperty "roleType"
    }

fun UsersMapper.insertMultiple(vararg records: Users) =
    insertMultiple(records.toList())

fun UsersMapper.insertSelective(row: Users) =
    insert(this::insert, row, users) {
        map(id).toPropertyWhenPresent("id", row::id)
        map(username).toPropertyWhenPresent("username", row::username)
        map(password).toPropertyWhenPresent("password", row::password)
        map(viewName).toPropertyWhenPresent("viewName", row::viewName)
        map(roleType).toPropertyWhenPresent("roleType", row::roleType)
    }

private val columnList = listOf(id, username, password, viewName, roleType)

fun UsersMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, users, completer)

fun UsersMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, users, completer)

fun UsersMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, users, completer)

fun UsersMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun UsersMapper.update(completer: UpdateCompleter) =
    update(this::update, users, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Users) =
    apply {
        set(id) equalToOrNull row::id
        set(username) equalToOrNull row::username
        set(password) equalToOrNull row::password
        set(viewName) equalToOrNull row::viewName
        set(roleType) equalToOrNull row::roleType
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Users) =
    apply {
        set(id) equalToWhenPresent row::id
        set(username) equalToWhenPresent row::username
        set(password) equalToWhenPresent row::password
        set(viewName) equalToWhenPresent row::viewName
        set(roleType) equalToWhenPresent row::roleType
    }

fun UsersMapper.updateByPrimaryKey(row: Users) =
    update {
        set(username) equalToOrNull row::username
        set(password) equalToOrNull row::password
        set(viewName) equalToOrNull row::viewName
        set(roleType) equalToOrNull row::roleType
        where { id isEqualTo row.id!! }
    }

fun UsersMapper.updateByPrimaryKeySelective(row: Users) =
    update {
        set(username) equalToWhenPresent row::username
        set(password) equalToWhenPresent row::password
        set(viewName) equalToWhenPresent row::viewName
        set(roleType) equalToWhenPresent row::roleType
        where { id isEqualTo row.id!! }
    }