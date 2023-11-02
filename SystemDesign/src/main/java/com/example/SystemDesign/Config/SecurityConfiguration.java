package com.example.SystemDesign.Config;

import com.example.SystemDesign.Domain.Permission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    public final JwtAuthinticationFilter jwtAuthFilter;
    public final AuthenticationProvider authenticationProvider;

    public SecurityConfiguration(JwtAuthinticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.authenticationProvider = authenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
       http.csrf(CsrfConfigurer<HttpSecurity>::disable)

               .authorizeHttpRequests(

                       request -> request.requestMatchers("api/v1/authentication/**")
                       .permitAll()
                       .requestMatchers(HttpMethod.GET,"api/v1/item/**")
                       .hasAnyAuthority(Permission.VIEW.name(),Permission.EDIT.name())
                       .requestMatchers(HttpMethod.POST)
                               .hasAuthority(Permission.EDIT.name())
               )
               .authenticationProvider(authenticationProvider)
               .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
               .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}
