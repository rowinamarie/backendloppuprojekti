package loppuprojekti24.loppuprojekti.web;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private KayttajaServiceImpl kayttajaDetailsService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(antMatcher("/css/**")).permitAll() // Enable css when logged out
                        .requestMatchers(antMatcher("/h2-console/**")).hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/delete/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(formlogin -> formlogin
                        .defaultSuccessUrl("/lista", true).permitAll())
                .logout(logout -> logout
                        .permitAll());

//H2 VARTEN
        http.csrf(csrf -> csrf.ignoringRequestMatchers(antMatcher("/h2-console/**")));
        http.headers(headers -> headers.frameOptions().sameOrigin());

        // LOPPUU TÄHÄN

        return http.build();
    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(kayttajaDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
