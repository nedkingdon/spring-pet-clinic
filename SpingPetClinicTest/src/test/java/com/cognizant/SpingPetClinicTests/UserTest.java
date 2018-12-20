package com.cognizant.SpingPetClinicTests;

import org.json.JSONObject;
import org.json.JSONArray;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UserTest {
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;	

	@Test
	public void postRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");
		
		JSONObject roles = new JSONObject();
		roles.put("id", "1");
		roles.put("name", "name");
		
		JSONArray arr = new JSONArray();
		arr.put(roles);

		JSONObject speciality = new JSONObject();
		speciality.put("enabled", "true");
		speciality.put("password", "pass");
		speciality.put("roles", arr);
		speciality.put("username", "user");
		
		request.body(speciality.toString());
		
		response = request.post("http://localhost:9966/petclinic/api/users/");
		json = response.then().statusCode(201);
	}

}
