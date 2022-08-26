package com.juaracoding.posttest21;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestCRUD {

	@Test (priority = 1)
	public void testPost() {
		//https://reqres.in/api/users
		JSONObject request = new JSONObject();
		request.put("name","Gayung");
		request.put("category", "Mandi");
		request.put("price", "15000");
		System.out.println(request.toJSONString());
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://mern-backend-8881.herokuapp.com/products")
		.then()
		.statusCode(200)
		.log().all();
	}
		
	
	@Test (priority = 2)
	public void testPut() {
		JSONObject request = new JSONObject();
		request.put("name","Ember");
		request.put("category", "Peralatan Mandi");
		request.put("price", "25000");
		System.out.println(request.toJSONString());
			
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("https://mern-backend-8881.herokuapp.com/products/630836f8b1ab8555847b5d39")
		.then()
		.statusCode(200)
		.log().all();
	}
		
	@Test (priority = 3)
	public void testPatch() {
			JSONObject request = new JSONObject();
			request.put("name","Bak");
			System.out.println(request.toJSONString());
			
			given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
			.when()
			.patch("https://mern-backend-8881.herokuapp.com/products/630836f8b1ab8555847b5d39")
			.then()
			.statusCode(200)
			.log().all();
		}
		
		@Test (priority = 4)
		public void testDelete() {
			when()
			.delete("https://mern-backend-8881.herokuapp.com/products/6307a88cc79932551ce126fa")
			.then()
			.statusCode(204)
			.log().all();
			
		
		
		
		
	}
}
