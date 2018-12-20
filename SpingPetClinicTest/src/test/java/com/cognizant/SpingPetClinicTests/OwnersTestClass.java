package com.cognizant;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class OwnersTestClass {

	private RequestSpecification req;
	private Response res;
	private ValidatableResponse json;

	@Test
	public void getOwners() {
		RestAssured.given().contentType(ContentType.JSON).when().get("http://localhost:9966/petclinic/api/owners")
				.then().statusCode(200);
	}

	 @Test
	 public void addOwner() throws JSONException {
	 req = RestAssured.given().contentType(ContentType.JSON);
	 req.header("Content-Type", "application/json");
	
	 JSONObject jsonObject = new JSONObject();
	 jsonObject.put("id", "1");
	 jsonObject.put("firstName", "Nichola");
	 jsonObject.put("lastName", "Ward");
	 jsonObject.put("address", "House");
	 jsonObject.put("city", "Manchester");
	 jsonObject.put("telephone", "1123456489");
	 JSONObject petObject = new JSONObject();
	 petObject.put("id", "13");
	 petObject.put("name", "leo");
	 petObject.put("birthDate", "2010/09/07");
	 JSONObject typeObject = new JSONObject();
	 petObject.put("type", typeObject);
	 typeObject.put("id", "1");
	 typeObject.put("name", "cat");
	 petObject.put("owner", "101");
	 JSONArray visitsArr = new JSONArray();
	 petObject.put("visits", visitsArr);
	 JSONArray arr = new JSONArray();
	 arr.put(petObject);
	 jsonObject.put("pets", arr);
	
	
	 req.body(jsonObject.toString());
	 res = req.post("http://localhost:9966/petclinic/api/owners");
	 json = res.then().statusCode(201);
	 }

	@Test
	public void getOwnersByLastName() {
		RestAssured.given().contentType(ContentType.JSON).when()
				.get("http://localhost:9966/petclinic/api/owners/*/lastname/Ward").then().statusCode(200);
	}

//	@Test
//	public void deleteOwnersByID() {
//		RestAssured.given().contentType(ContentType.JSON).when().delete("http://localhost:9966/petclinic/api/owners/11")
//				.then().statusCode(204);
//	}
//	
	@Test
	public void getOwnersByOwnerID() {
		RestAssured.given().contentType(ContentType.JSON).when().get("http://localhost:9966/petclinic/api/owners/1")
				.then().statusCode(200);
//		assertEquals("", "", res.body("{}"));
	}
	
	 @Test
	 public void updateOwnerByID() throws JSONException {
	 req = RestAssured.given().contentType(ContentType.JSON);
	 req.header("Content-Type", "application/json");
	
	 JSONObject jsonObject = new JSONObject();
	 jsonObject.put("id", "1");
	 jsonObject.put("firstName", "Nichola");
	 jsonObject.put("lastName", "Ward");
	 jsonObject.put("address", "House");
	 jsonObject.put("city", "Manchester");
	 jsonObject.put("telephone", "1123456489");
	 JSONObject petObject = new JSONObject();
	 petObject.put("id", "13");
	 petObject.put("name", "leo");
	 petObject.put("birthDate", "2010/09/07");
	 JSONObject typeObject = new JSONObject();
	 petObject.put("type", typeObject);
	 typeObject.put("id", "1");
	 typeObject.put("name", "cat");
	 petObject.put("owner", "101");
	 JSONArray visitsArr = new JSONArray();
	 petObject.put("visits", visitsArr);
	 JSONArray arr = new JSONArray();
	 arr.put(petObject);
	 jsonObject.put("pets", arr);
	
	
	 req.body(jsonObject.toString());
	 res = req.put("http://localhost:9966/petclinic/api/owners/1");
	 json = res.then().statusCode(204);
	 }
}
