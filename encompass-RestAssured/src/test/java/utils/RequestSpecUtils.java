package utils;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.LoginMultiUserPojo;
import pojo.LoginRequestPojo;

public class RequestSpecUtils {
	
	
	
	public static RequestSpecification loginSpec() {
		
		LoginRequestPojo loginBody=new LoginRequestPojo("mor_2314", "83r5^_"); 
		return given().baseUri("https://fakestoreapi.com")
				.contentType(ContentType.JSON)
				.header("User-Agent", "Mozilla/5.0")
				.body(loginBody);
	}


	public static RequestSpecification getProducts() {
		return given().baseUri("https://fakestoreapi.com")
	            .contentType(ContentType.JSON)
	            .header("User-Agent", "Mozilla/5.0"); 
	}

}
