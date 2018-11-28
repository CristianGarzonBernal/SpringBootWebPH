package com.pacto.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.management.Query;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class Authentication extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/landing").hasAnyAuthority("PSICOLOGO", "JUGADOR")
                .antMatchers("/registration").permitAll()
                .antMatchers("/psicologo/**").hasAuthority("PSICOLOGO")
                .antMatchers("/jugador/**").hasAuthority("JUGADOR")
                .anyRequest()
                .authenticated().and().
                formLogin()
                .loginPage("/login").failureUrl("/login?error=true")
                .defaultSuccessUrl("/landing")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                ;


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)

                .usersByUsernameQuery(
                        "select email, password, active from user where email=?")
                .authoritiesByUsernameQuery(
                        "select u.email, r.role from user u inner join user_role ur on" +
                                "(u.user_id=ur.user_id) inner join role r on(ur.role_id=r.role_id) where u.email=?")
                .passwordEncoder(bCryptPasswordEncoder);

    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
