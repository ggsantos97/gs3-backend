package com.gs3.avaliacao.junior.gs3backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Gs3BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Gs3BackendApplication.class, args);
	}
	@Autowired
	private Environment env;

	@Bean
	public WebMvcConfigurer corsConfigure(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				String urls = env.getProperty("cors.urls");
				CorsRegistration reg =
				registry.addMapping("/api/**");
						for(String url: urls.split(",")){
							reg.allowedOrigins(url);
						}
			}
		};
	}

}
