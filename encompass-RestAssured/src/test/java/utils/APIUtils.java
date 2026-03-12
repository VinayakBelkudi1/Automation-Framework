package utils;

import io.restassured.response.Response;
import pojo.LoginMultiUserPojo;


import static io.restassured.RestAssured.*;

public class APIUtils {
	
	 
	public static Response getRequest(String endpoint,String token) {
		return given()
				.header("Authorization",token)
				.when()
				.get(endpoint);
	}
	
	public static Response postRequest(String endpoint,Object body,String token) {
		return given()
				.header("Authorization",token)
				.body(body)
				.when()
				.post(endpoint);
	}
	
	public static String getToken() {
		return given().spec(RequestSpecUtils.loginSpec())
		.when().post("/auth/login")
		.then().statusCode(200)
			   .extract()
			   .path("token");
	}

}
