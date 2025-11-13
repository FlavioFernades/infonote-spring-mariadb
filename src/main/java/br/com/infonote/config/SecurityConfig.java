package br.com.infonote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // 🔓 desativa CSRF para permitir POST livre
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // 🔓 libera tudo temporariamente
            )
            .formLogin(form -> form.disable()) // desativa o login padrão
            .logout(logout -> logout.permitAll()); // libera logout também

        return http.build();
    }
}
