package com.filescanner.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cardinalhealth.filescanner.application.Contact;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class OrderSwaggerConfig {

	public OrderSwaggerConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Value("${api.title}")
	private transient String title;
	
	@Value("${api.description}")
	private transient String description;
	
	@Value("${api.version}")
	private transient String version;
	
	@Value("${api.description}")
	private transient String termsOfServiceUrl;
	
	@Value("${api.contact}")
	private transient String contact;
	
	@Value("${api.license}")
	private transient String license;
	
	@Value("${api.licenseUrl}")
	private transient String licenseUrl;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cardinalhealth.filescanner"))
				.paths(PathSelectors.any()).build()
				.apiInfo(new ApiInfo(
					title, // Title
					description, // Description
					version, // Version
					termsOfServiceUrl, // Terms of Service URL
					new Contact(contact, "", ""), // Contact
					license, // License
					licenseUrl));
	}
	
}
