package com.sunonebytes.openapi.client.web;

import com.sunonebytes.openapi.client.gen.web.model.Customer;
import com.sunonebytes.openapi.client.gen.web.model.CustomerNamePatchRequest;
import com.sunonebytes.openapi.client.gen.web.model.GetCustomersResponse;
import com.sunonebytes.openapi.client.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerClientRestController {

	public CustomerService customerService;

	public CustomerClientRestController(CustomerService customerService){
		this.customerService = customerService;

	}

	@GetMapping(value="/v1/customer-client", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GetCustomersResponse> getCustomers(){
		return customerService.getCustomers();
	}

	@GetMapping(value="/v1/customer-client/{customerNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerNumber") Integer customerNumber){
		return customerService.getCustomer(customerNumber);
	}

	@PostMapping(value = "/v1/customer-client", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createCustomer(Customer customer){
		return customerService.createCustomer(customer);
	}

	@PutMapping(value = "/v1/customer-client/{customer-number}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateCustomer(@PathVariable("customer-number") Integer customerNumber, Customer customer){
		return customerService.updateCustomer(customerNumber,customer);
	}

	@DeleteMapping(value = "/v1/customer-client")
	public ResponseEntity<Void> updateCustomer(@RequestParam("customerNumber") Integer customerNumber){
		return customerService.deleteCustomer(customerNumber);
	}

	@PatchMapping(value = "/v1/customer-client/{customer-number}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> patchCustomer(@PathVariable("customer-number") Integer customerNumber, CustomerNamePatchRequest customerNamePatchRequest){
		return customerService.patchCustomer(customerNumber,customerNamePatchRequest);
	}


}
