package maluevartem.secure_application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("User").password("{noop}user").authorities("read")
                .and()
                .withUser("Librarian").password("{noop}lib").authorities("read", "write")
                .and()
                .withUser("Administrator").password("{noop}admin").authorities("read", "write", "delete");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/hello").permitAll()
                .and()
                .authorizeRequests().antMatchers("/read").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("/write").hasAuthority("write")
                .and()
                .authorizeRequests().antMatchers("/delete").hasAuthority("delete")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
