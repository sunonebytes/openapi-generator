package com.sunonebytes.openapi.client.service;

import com.sunonebytes.openapi.client.gen.web.api.CustomerApi;
import com.sunonebytes.openapi.client.gen.web.model.Customer;
import com.sunonebytes.openapi.client.gen.web.model.CustomerNamePatchRequest;
import com.sunonebytes.openapi.client.gen.web.model.GetCustomersResponse;
import com.sunonebytes.openapi.client.service.exception.CustomerServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

	public CustomerApi customerApi;

	public CustomerService(CustomerApi customerAPi) {
		this.customerApi =customerAPi;
	}

	public ResponseEntity<GetCustomersResponse> getCustomers(){
		//return customerApi.getCustomers().getItems();
		ResponseEntity<GetCustomersResponse> responseEntity =  customerApi.getCustomersWithHttpInfo();
		if(responseEntity.getStatusCode().equals(HttpStatus.OK)){
			return responseEntity;
		}
		return null;
	}

	public ResponseEntity<Customer> getCustomer(Integer customerNumber){
		//return customerApi.getCustomer(customerNumber);
		ResponseEntity<Customer> responseEntity =  customerApi.getCustomerWithHttpInfo(customerNumber);
		if(responseEntity.getStatusCode().equals(HttpStatus.OK)){
			return responseEntity;
		}
		return null;
	}

	public ResponseEntity<Void> createCustomer(Customer customer) throws CustomerServiceException {
		//customerApi.createCustomer(customer);
		ResponseEntity<Void> responseEntity =  customerApi.createCustomerWithHttpInfo(customer);
		if(!responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
			throw new CustomerServiceException();
		}
		return responseEntity;
	}

	public ResponseEntity<Void> updateCustomer(Integer customerNumber, Customer customer){
		//customerApi.updateCustomer(customerNumber,customer);
		ResponseEntity<Void> responseEntity =  customerApi.updateCustomerWithHttpInfo(customerNumber,customer);
		if(!responseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
			throw new CustomerServiceException();
		}
		return responseEntity;
	}

	public ResponseEntity<Void> deleteCustomer(Integer customerNumber){
		//customerApi.deleteCustomer(customerNumber);
		ResponseEntity<Void> responseEntity =  customerApi.deleteCustomerWithHttpInfo(customerNumber);
		if(!responseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
			throw new CustomerServiceException();
		}
		return responseEntity;
	}

	public ResponseEntity<Void> patchCustomer(Integer customerNumber, CustomerNamePatchRequest customerNamePatchRequest){
		//customerApi.patchCustomerName(customerNumber,customerNamePatchRequest);
		ResponseEntity<Void> responseEntity =  customerApi.patchCustomerNameWithHttpInfo(customerNumber,customerNamePatchRequest);
		if(!responseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
			throw new CustomerServiceException();
		}
		return responseEntity;
	}
}
