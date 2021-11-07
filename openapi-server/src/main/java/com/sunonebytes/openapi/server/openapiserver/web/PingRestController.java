package com.sunonebytes.openapi.server.openapiserver.web;

import com.sunonebytes.openapi.server.gen.web.api.PingApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingRestController implements PingApi {

	@Override
	public ResponseEntity<Void> ping() {
		return PingApi.super.ping();
	}
}
