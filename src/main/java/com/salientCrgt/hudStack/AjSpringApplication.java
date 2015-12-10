package com.salientCrgt.hudStack;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// import
// org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class AjSpringApplication extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(AjSpringApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(
            final SpringApplicationBuilder application) {
        return application.sources(AjSpringApplication.class);
    }

    @Bean
    public KieContainer kieContainer() {
        return KieServices.Factory.get().getKieClasspathContainer();
    }

    // @Bean
    // public WebMvcConfigurer corsConfigurer() {
    // return new WebMvcConfigurerAdapter() {
    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    // registry.addMapping("/caivrsSearch/*").allowedOrigins("http://127.0.0.1:64990");
    // }
    // };
    // }
}
