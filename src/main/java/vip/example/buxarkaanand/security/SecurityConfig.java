package vip.example.buxarkaanand.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    public void configureGlobal(UserDetailsManager auth) throws Exception {
//        auth.createUser(
//                UserDetails.withUsername("user")
//                        .password("{noop}password") // Use a password encoder for production
//                        .roles("USER")
//                        .build());
//    }
//
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests(authorizeHttpRequests ->
                        authorizeHttpRequests
                        .requestMatchers("/admin/**").authenticated()
                        .anyRequest().permitAll()
                ).
                formLogin(form -> form
                         // Optional for default login page
                        .defaultSuccessUrl("/admin")
                        .permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/admin")).build();
    }
}
