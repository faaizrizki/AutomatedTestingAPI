package com.juaracoding.posttest21;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGet{

	String endpoint = "https://mern-backend-8881.herokuapp.com/products";
	
	@Test
	public void testStatusCode() {
		Response response = RestAssured.get(endpoint);
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int actual = response.getStatusCode();
		System.out.println("Berhasil");
		assertEquals(actual, 200);
	}
	
	@Test
	public void testId() {
		given()
		.get(endpoint)
		.then()
		.statusCode(200)
		.body("_id[0]", equalTo("62b3f69f66f12cc8cf17fcef"));
	}

	
}
