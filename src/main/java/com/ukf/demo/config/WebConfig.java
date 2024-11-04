package com.ukf.demo.config;



import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Map the /uploads/** URL to the actual file system location where images are
		// stored
		Path uploadDir = Paths.get("uploads");
		String uploadPath = uploadDir.toFile().getAbsolutePath();

		registry.addResourceHandler("/uploads/**").addResourceLocations("file:" + uploadPath + "/");
	}
}