package com.stackoverflow.q75696096;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toStaticResources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Q75696096Application
    implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(Q75696096Application.class, args);
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/").setViewName("index");
    registry.addViewController("/secured").setViewName("secured");
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(
            (requests) -> requests
                .requestMatchers(toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
        )
        .formLogin(Customizer.withDefaults()).build();
  }
}
