package jp.ac.it_college.std.s21011.news_manager.application.service.security

import jp.ac.it_college.std.s21011.news_manager.application.service.AuthenticationService
import jp.ac.it_college.std.s21011.news_manager.domain.enum.RoleType
import jp.ac.it_college.std.s21011.news_manager.domain.model.Users
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class NewsManagerUsersDetailService(
    private val authenticationService: AuthenticationService
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails? {
        val user = authenticationService.findUsers(username ?: "")
        return user?.let { NewsManagerUsersDetails(user) }
    }
}

data class NewsManagerUsersDetails(
    val id: Long, val user: String, val pass: String, val  viewName: String, val roleType: RoleType
) : UserDetails {
    constructor(users: Users) : this(
        users.id, users.username, users.password, users.viewName, users.roleType
    )

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList(this.roleType.toString())
    }

    override fun getPassword(): String {
        return this.pass
    }

    override fun getUsername(): String {
        return this.user
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}