package com.cognizant.SpingPetClinicTests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class VetTest {
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;


	@Test
	public void getAllRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:9966/petclinic/api/vets/");
		json = response.then().statusCode(200);
	}
	
	@Test
	public void getOneRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:9966/petclinic/api/vets/3");
		json = response.then().statusCode(200);
	}

	@Test
	public void postRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject fr = new JSONObject();
		fr.put("id", "2");
		fr.put("name", "");
		
		JSONArray spec = new JSONArray();
		spec.put(fr);
		
		JSONObject vet = new JSONObject();
		vet.put("id", "15");
		vet.put("firstName", "NEW");
		vet.put("lastName", "NEW");
		vet.put("specialties", spec);
		request.body(vet.toString());
		
		response = request.post("http://localhost:9966/petclinic/api/vets/");
		json = response.then().statusCode(201);
	}

	@Test
	public void putRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject fr = new JSONObject();
		fr.put("id", "3");
		fr.put("name", "");
		
		JSONArray spec = new JSONArray();
		spec.put(fr);
		
		JSONObject vet = new JSONObject();
		vet.put("id", "1");
		vet.put("firstName", "RENAMED");
		vet.put("lastName", "RENAMED");
		vet.put("specialties", spec);
		request.body(vet.toString());
		
		response = request.put("http://localhost:9966/petclinic/api/vets/3");
		json = response.then().statusCode(204);
	}

	@Test
	public void deleteRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);		
		response = request.when().delete("http://localhost:9966/petclinic/api/vets/14");
		json = response.then().statusCode(204);
	}

}
