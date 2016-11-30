package org.elevenfifty.shopping;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	/* httpSecurity.authorizeRequests().anyRequest().permitAll();*/
        httpSecurity
        .authorizeRequests().antMatchers("/h2-console/**").permitAll()
        .and()
        .authorizeRequests().antMatchers("/console/**").permitAll()
        .and()
        .authorizeRequests().antMatchers("/").authenticated().anyRequest().permitAll()
        .and()
        .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
        .and()
        
        .logout().logoutSuccessUrl("/login?logout")
        .and()
        .csrf().disable()
        .headers().frameOptions().disable();
        
    }
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception{
    	auth.jdbcAuthentication()
    	.dataSource(dataSource)
    	.rolePrefix("")
    	.passwordEncoder(new PlaintextPasswordEncoder())
    	.usersByUsernameQuery("select email as username, password, active as enabled from java301.users where email = ?")
    	.authoritiesByUsernameQuery("select u.email as username, ur.role as authority from java301.users u inner join java301.user_roles ur on (u.id=ur.user_id) where u.email=?");
    }
}