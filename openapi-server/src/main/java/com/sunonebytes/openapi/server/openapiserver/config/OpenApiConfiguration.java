package com.sunonebytes.openapi.server.openapiserver.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

	@Bean
	public OpenAPI openAPI(){
		return new OpenAPI()
				.info(new Info()
				.title("Customer API")
				.version("1.0").license(
				 new License()
						.name("Sunone Bytes")
						.url("https://sunonebytes.com")));
	}

	@Bean
	public GroupedOpenApi pingOpenAPI(){
		String[] paths = {"/v1/ping/**"};
		return GroupedOpenApi.builder().group("Ping API V1").pathsToMatch(paths).build();
	}

	@Bean
	public GroupedOpenApi customerOpenAPI(){
		String[] paths = {"/v1/customers/**"};
		return GroupedOpenApi.builder().group("Customer API V1").pathsToMatch(paths).build();
	}

	@Bean
	public GroupedOpenApi addressOpenAPI(){
		String[] paths = {"/v1/address/**"};
		return GroupedOpenApi.builder().group("Address API V1").pathsToMatch(paths).build();
	}
}
