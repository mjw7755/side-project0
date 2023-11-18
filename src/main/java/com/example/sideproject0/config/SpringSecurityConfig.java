package com.example.sideproject0.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(request -> request
                                .requestMatchers("/**").permitAll()
                        /*.requestMatchers("/api/**").permitAll()
                        .requestMatchers("/index.do").permitAll()
                        .requestMatchers("/login.do").permitAll()
                        .requestMatchers("/swagger-ui/index.html").permitAll()*/
                )
                .formLogin(login -> login
                        .loginPage("/login.do")
                        .successHandler(new SimpleUrlAuthenticationSuccessHandler("/index.do"))
                        .permitAll()
                )
                .authorizeHttpRequests(request -> request.anyRequest().authenticated());

        return http.build();
    }
}
