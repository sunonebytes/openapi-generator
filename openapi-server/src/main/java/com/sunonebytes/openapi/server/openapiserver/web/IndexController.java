package com.sunonebytes.openapi.server.openapiserver.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@RestController("/")
public class IndexController {

	@GetMapping
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("/api");
	}
}
