package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecUtils {

	public static ResponseSpecification getResSpec() {
		
		return new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType("application/json")
				.build();
		
	}
}
