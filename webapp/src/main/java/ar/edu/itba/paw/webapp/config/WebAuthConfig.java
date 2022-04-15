package ar.edu.itba.paw.webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.concurrent.TimeUnit;

@ComponentScan({ "ar.edu.itba.paw.webapp.auth" })
@EnableWebSecurity
@Configuration
public class WebAuthConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .invalidSessionUrl("/login")
            .and().authorizeRequests()
                .antMatchers("/login", "/create").anonymous()
                .antMatchers("/post/edit").hasRole("EDITOR")
                .antMatchers("/**").authenticated()
            .and().formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/", false)
                .loginPage("/login")
            .and().rememberMe()
                .rememberMeParameter("rememberme")
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30))
            .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("login")
            .and().exceptionHandling()
                .accessDeniedPage("/403")
            .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
}