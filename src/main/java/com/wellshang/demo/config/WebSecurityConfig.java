package com.wellshang.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.wellshang.demo.service.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService();

    }

    /**
     * If subclassed this will potentially override subclass configure(HttpSecurity)
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/amchart/**",
                "/bootstrap/**",
                "/build/**",
                "/css/**",
                "/dist/**",
                "/documentation/**",
                "/fonts/**",
                "/js/**",
                "/pages/**",
                "/plugins/**",
                "/h2console/**"
            ).permitAll()
            .anyRequest().authenticated().and()
            .formLogin().loginPage("/login")
            .defaultSuccessUrl("/httpapi").permitAll().and()
            .logout().permitAll();

        http.logout().logoutSuccessUrl("/");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//            .withUser("root")
//            .password("root")
//            .roles("ADMIN", "USER")
//            .and()
//            .withUser("admin").password("admin")
//            .roles("ADMIN", "USER")
//            .and()
//            .withUser("user").password("user")
//            .roles("USER");

        //AuthenticationManager使用我们的 lightSwordUserDetailService 来获取用户信息
        auth.userDetailsService(userDetailsService());
    }
}