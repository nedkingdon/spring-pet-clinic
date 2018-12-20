package com.cognizant.SpingPetClinicTests;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SpecialitiesTest {
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;


	@Test
	public void getAllRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:9966/petclinic/api/specialties/");
		json = response.then().statusCode(200);
	}
	
	@Test
	public void getOneRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:9966/petclinic/api/specialties/2");
		json = response.then().statusCode(200);
	}

	@Test
	public void postRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject speciality = new JSONObject();
		speciality.put("id", "3");
		speciality.put("name", "NEWPET");
		
		request.body(speciality.toString());
		
		response = request.post("http://localhost:9966/petclinic/api/specialties/");
		json = response.then().statusCode(201);
	}

	@Test
	public void putRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject speciality = new JSONObject();
		speciality.put("id", "3");
		speciality.put("name", "RENAMED");
		
		request.body(speciality.toString());
		
		response = request.put("http://localhost:9966/petclinic/api/specialties/2/");
		json = response.then().statusCode(204);
	}

	@Test
	public void deleteRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);		
		response = request.when().delete("http://localhost:9966/petclinic/api/specialties/1");
		json = response.then().statusCode(204);
	}


}
