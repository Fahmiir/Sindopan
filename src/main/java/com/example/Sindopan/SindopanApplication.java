package com.example.Sindopan;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SindopanApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SindopanApplication.class, args);
	}
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
