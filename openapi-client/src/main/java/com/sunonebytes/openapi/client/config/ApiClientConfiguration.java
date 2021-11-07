package com.sunonebytes.openapi.client.config;

import com.sunonebytes.openapi.client.gen.web.ApiClient;
import com.sunonebytes.openapi.client.gen.web.api.AddressApi;
import com.sunonebytes.openapi.client.gen.web.api.CustomerApi;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiClientConfiguration {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.defaultMessageConverters().build();

		//For Http Patch Method : The standard JDK HTTP library does not support HTTP PATCH. need to use the Apache HttpClent from HttpComponents Library
		//Ref: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html#patchForObject-java.lang.String-java.lang.Object-java.lang.Class-java.util.Map-
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		requestFactory.setReadTimeout(600000);
		requestFactory.setConnectTimeout(600000);
		restTemplate.setRequestFactory(requestFactory);
		return restTemplate;
	}

	@Bean
	public ApiClient apiClient(RestTemplate restTemplate) {
		return new ApiClient(restTemplate);
	}

	@Bean
	public CustomerApi customerAPi(ApplicationProperties properties,ApiClient apiClient){
		return new CustomerApi(apiClient.setBasePath(properties.getCustomerPropertiesApi().getBasePath()));
	}

	@Bean
	public AddressApi addressApi(ApplicationProperties properties,ApiClient apiClient){
		return  new AddressApi(apiClient.setBasePath(properties.getAddressPropertiesApi().getBasePath()));
	}
}
