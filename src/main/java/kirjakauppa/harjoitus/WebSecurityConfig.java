package kirjakauppa.harjoitus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configurate(HttpSecurity http) throws Exception{
        http
                .authorizeRequests().antMatchers("kirja/{id}").hasAnyAuthority("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/css/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/signup", "/saveuser").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/mainpage")
                    .permitAll()
                    .and()
                    .logout()
                        .permitAll(); }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
        //auth.userDetailsService(userDetailsService).passwordEncoder(new
        //        BCryptPasswordEncoder());
    }}