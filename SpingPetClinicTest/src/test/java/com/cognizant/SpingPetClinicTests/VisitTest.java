package com.cognizant.SpingPetClinicTests;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class VisitTest {
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;


	@Test
	public void getAllRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:9966/petclinic/api/visits/");
		json = response.then().statusCode(200);
	}
	
	@Test
	public void getOneRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:9966/petclinic/api/visits/2");
		json = response.then().statusCode(200);
	}

	@Test
	public void postRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject type = new JSONObject();
		type.put("id", "1");
		type.put("name", "Dog");

		JSONObject owner = new JSONObject();
		owner.put("id", "1");
		owner.put("firstName", "Josh");
		owner.put("lastName", "Lewis");
		owner.put("address", "Straat Street");
		owner.put("city", "London");
		owner.put("telephone", "01189998119991197253");

		JSONObject pet = new JSONObject();
		pet.put("id", "13");
		pet.put("name", "");
		pet.put("birthDate", "0000/10/06");
		pet.put("type", type);
		pet.put("owner", owner);

		JSONObject visit = new JSONObject();
		visit.put("id", "1000");
		visit.put("date", "2011/12/25");
		visit.put("description", "NENENENENENENEN");
		visit.put("pet", pet);
		System.out.println(visit.toString());
		request.body(visit.toString());
		
		response = request.post("http://localhost:9966/petclinic/api/visits/");
		json = response.then().statusCode(201);
	}

	@Test
	public void putRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject type = new JSONObject();
		type.put("id", "100");
		type.put("name", "Dog");

		JSONObject owner = new JSONObject();
		owner.put("id", "100");
		owner.put("firstName", "Josh");
		owner.put("lastName", "Lewis");
		owner.put("address", "Straat Street");
		owner.put("city", "London");
		owner.put("telephone", "01189998119991197253");

		JSONObject pet = new JSONObject();
		pet.put("id", "13");
		pet.put("name", "");
		pet.put("birthDate", "0000/10/06");
		pet.put("type", type);
		pet.put("owner", owner);

		JSONObject visit = new JSONObject();
		visit.put("id", "1000");
		visit.put("date", "2011/12/25");
		visit.put("description", "NENENENENENENEN");
		visit.put("pet", pet);
		System.out.println(visit.toString());
		request.body(visit.toString());
		
		response = request.put("http://localhost:9966/petclinic/api/visits/2/");
		json = response.then().statusCode(204);
	}

	@Test
	public void deleteRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);		
		response = request.when().delete("http://localhost:9966/petclinic/api/visits/14");
		json = response.then().statusCode(204);
	}
}
