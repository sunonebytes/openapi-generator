package com.sunonebytes.openapi.server.openapiserver.web;

import com.sunonebytes.openapi.server.gen.web.api.AddressApi;
import com.sunonebytes.openapi.server.gen.web.model.AddressView;
import com.sunonebytes.openapi.server.gen.web.model.GetAddressesResponseView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressRestController implements AddressApi {

	@Override
	public ResponseEntity<Void> createAddress(Integer customerNumber, AddressView addressView) {
		return AddressApi.super.createAddress(customerNumber, addressView);
	}

	@Override
	public ResponseEntity<Void> deleteAddress(Integer customerNumber, String addressId) {
		return AddressApi.super.deleteAddress(customerNumber, addressId);
	}

	@Override
	public ResponseEntity<GetAddressesResponseView> getAddress(Integer customerNumber) {
		return AddressApi.super.getAddress(customerNumber);
	}

	@Override
	public ResponseEntity<Void> updateAddress(Integer customerNumber, String addressId, AddressView addressView) {
		return AddressApi.super.updateAddress(customerNumber, addressId, addressView);
	}
}
