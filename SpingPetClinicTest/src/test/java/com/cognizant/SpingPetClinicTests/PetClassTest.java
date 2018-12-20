package com.cognizant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PetClassTest {

	private RequestSpecification req;
	private Response res;
	private ValidatableResponse json;

	@Test
	public void getpets() {
		RestAssured.given().contentType(ContentType.JSON).when().get("http://localhost:9966/petclinic/api/pets").then()
				.statusCode(200);
	}

	@Test
	public void addPets() throws JSONException {
		req = RestAssured.given().contentType(ContentType.JSON);
		req.header("Content-Type", "application/json");

		JSONObject petObject = new JSONObject();
		petObject.put("id", "1");
		petObject.put("name", "leo");
		petObject.put("birthDate", "2010/09/07");
		JSONObject typeObject = new JSONObject();

		typeObject.put("id", "1");
		typeObject.put("name", "cat");
		petObject.put("type", typeObject);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
		jsonObject.put("firstName", "Nichola");
		jsonObject.put("lastName", "Ward");
		jsonObject.put("address", "House");
		jsonObject.put("city", "Manchester");
		jsonObject.put("telephone", "1123456489");
		petObject.put("owner", jsonObject);
		JSONArray visitsArr = new JSONArray();
		petObject.put("visits", visitsArr);

		req.body(petObject.toString());
		res = req.post("http://localhost:9966/petclinic/api/pets");
		json = res.then().statusCode(201);
	}

	@Test
	public void getPetTypes() {
		RestAssured.given().contentType(ContentType.JSON).when().get("http://localhost:9966/petclinic/api/pets/pettypes")
				.then().statusCode(200);
	}
	
//	@Test
//	public void deletePetsByID() {
//		RestAssured.given().contentType(ContentType.JSON).when().delete("http://localhost:9966/petclinic/api/pets/1")
//				.then().statusCode(204);
//	}
	
	@Test
	public void getPetsByID() {
		RestAssured.given().contentType(ContentType.JSON).when().get("http://localhost:9966/petclinic/api/pets/2")
				.then().statusCode(200);
	}
	
	@Test
	public void updatePetsByID() throws JSONException {
		req = RestAssured.given().contentType(ContentType.JSON);
		req.header("Content-Type", "application/json");

		JSONObject petObject = new JSONObject();
		petObject.put("id", "2");
		petObject.put("name", "leo J");
		petObject.put("birthDate", "2010/09/07");
		JSONObject typeObject = new JSONObject();

		typeObject.put("id", "1");
		typeObject.put("name", "cat");
		petObject.put("type", typeObject);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
		jsonObject.put("firstName", "Nichola");
		jsonObject.put("lastName", "Ward");
		jsonObject.put("address", "House");
		jsonObject.put("city", "Manchester");
		jsonObject.put("telephone", "1123456489");
		petObject.put("owner", jsonObject);
		JSONArray visitsArr = new JSONArray();
		petObject.put("visits", visitsArr);

		req.body(petObject.toString());
		res = req.put("http://localhost:9966/petclinic/api/pets/2");
		json = res.then().statusCode(204);
	}

}
