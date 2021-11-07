package com.sunonebytes.openapi.server.openapiserver.web;

import com.sunonebytes.openapi.server.gen.web.api.CustomerApi;
import com.sunonebytes.openapi.server.gen.web.model.AddressView;
import com.sunonebytes.openapi.server.gen.web.model.CustomerNamePatchRequestView;
import com.sunonebytes.openapi.server.gen.web.model.CustomerView;
import com.sunonebytes.openapi.server.gen.web.model.GetCustomersResponseView;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@RestController
public class CustomerRestController implements CustomerApi {

	@Override
	public ResponseEntity<Void> createCustomer(CustomerView customerView) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header","createCustomer");

		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Void> deleteCustomer(Integer customerNumber) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header","deleteCustomer");

		return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<CustomerView> getCustomer(Integer customerNumber) {
		CustomerView customerView = getCustomerView();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header","GetCustomer");

		return new ResponseEntity<>(customerView,headers, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GetCustomersResponseView> getCustomers() {
		CustomerView customerView1 = getCustomerView();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header","GetCustomers");

		GetCustomersResponseView view = new GetCustomersResponseView();
		view.addItemsItem(customerView1);
		//return CustomerApi.super.getCustomers();
		return new ResponseEntity<>(view,headers, HttpStatus.OK);
	}

	private CustomerView getCustomerView() {
		CustomerView customerView1 = new CustomerView();
		customerView1.setId(122L);
		customerView1.setCustomerNumber(23423);
		customerView1.setCustomerName("Vishnu");
		customerView1.setCustomerEmail("vishnu@example.com");
		customerView1.setCustomerPhone("2342342222");
		customerView1.setCreatedDate(OffsetDateTime.now());
		customerView1.customerFees(2134.44);
		customerView1.dateOfBirth(LocalDate.now());
		AddressView addressView1 = new AddressView();
		addressView1.setAddressType("HOME");
		addressView1.setAddressLine1("#58, Main Road");
		addressView1.setAddressLine2("Park Ave");
		addressView1.setCity("Garden City");
		addressView1.setZipCode("23422");
		addressView1.setState("New York");
		addressView1.setCountry("US");
		customerView1.addAddressesItem(addressView1);
		return customerView1;
	}

	@Override
	public ResponseEntity<Void> patchCustomerName(Integer customerNumber, CustomerNamePatchRequestView customerNamePatchRequestView) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header","patchCustomerName");

		return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Void> updateCustomer(Integer customerNumber, CustomerView customerView) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header","updateCustomer");

		return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
	}
}
