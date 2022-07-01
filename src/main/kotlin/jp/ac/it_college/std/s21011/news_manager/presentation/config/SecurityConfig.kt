package jp.ac.it_college.std.s21011.news_manager.presentation.config

import jp.ac.it_college.std.s21011.news_manager.application.service.AuthenticationService
import jp.ac.it_college.std.s21011.news_manager.application.service.security.NewsManagerUsersDetailService
import jp.ac.it_college.std.s21011.news_manager.domain.enum.RoleType
import jp.ac.it_college.std.s21011.news_manager.presentation.handler.NewsManagerAccessDeniedHandler
import jp.ac.it_college.std.s21011.news_manager.presentation.handler.NewsManagerAuthenticationEntryPoint
import jp.ac.it_college.std.s21011.news_manager.presentation.handler.NewsManagerAuthenticationFailureHandler
import jp.ac.it_college.std.s21011.news_manager.presentation.handler.NewsManagerAuthenticationSuccessHandler
import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@EnableWebSecurity
class SecurityConfig(private val authenticationService: AuthenticationService) {

    @Bean
    @Order(1)
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.authorizeRequests {
            it
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/admin/**").hasAuthority(RoleType.ADMIN.toString())
                .anyRequest().authenticated()
        }.formLogin {
            it
                .loginProcessingUrl("/login")
                .usernameParameter("user")
                .passwordParameter("pass")
                .successHandler(NewsManagerAuthenticationSuccessHandler())
                .failureHandler(NewsManagerAuthenticationFailureHandler())
        }.csrf {
            it
                .disable()
        }.exceptionHandling {
            it
                .authenticationEntryPoint(NewsManagerAuthenticationEntryPoint())
                .accessDeniedHandler(NewsManagerAccessDeniedHandler())
        }.cors {
            it
                .configurationSource(corsConfigurationSource())
        }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun userDetailsService(): UserDetailsService = NewsManagerUsersDetailService(authenticationService)

    private fun corsConfigurationSource(): CorsConfigurationSource {
        val config = CorsConfiguration().apply {
            addAllowedMethod(CorsConfiguration.ALL)
            addAllowedHeader(CorsConfiguration.ALL)
            addAllowedOrigin("http://localhost:8081/")
            allowCredentials = true
        }

        val source = UrlBasedCorsConfigurationSource().apply {
            registerCorsConfiguration("/**", config)
        }

        return source
    }
}