package com.keshav.webservice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Keshav", "linkedin.com/in/keshav-b-n-bb5243119/", "bn.keshav91@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Restful web service project", "Restful web service project description", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	public Set<String> types = new HashSet<>(Arrays.asList("application/xml","application/json"));

	@Bean
	public Docket configDocket(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
				.produces(types)
				.consumes(types);
	}
	
}
