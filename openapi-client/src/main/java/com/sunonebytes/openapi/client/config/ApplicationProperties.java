package com.sunonebytes.openapi.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
@PropertySources({
		@PropertySource(value = "classpath:git.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "classpath:META-INF/build-info.properties", ignoreResourceNotFound = true)
})
public class ApplicationProperties {

	private final CustomerPropertiesApi customerPropertiesApi = new CustomerPropertiesApi();

	private final AddressPropertiesApi addressPropertiesApi = new AddressPropertiesApi();

	public CustomerPropertiesApi getCustomerPropertiesApi() {
		return customerPropertiesApi;
	}

	public AddressPropertiesApi getAddressPropertiesApi() {
		return addressPropertiesApi;
	}

	public static class CustomerPropertiesApi {

		private String basePath;

		public String getBasePath() {
			return basePath;
		}
		public void setBasePath(String basePath) {
			this.basePath = basePath;
		}
	}

	public static class AddressPropertiesApi {

		private String basePath;

		public String getBasePath() {
			return basePath;
		}
		public void setBasePath(String basePath) {
			this.basePath = basePath;
		}
	}
}
