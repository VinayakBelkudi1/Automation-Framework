package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import utils.APIUtils;
import utils.RequestSpecUtils;
import utils.ResponseSpecUtils;

public class DummyTest {
	
	
 
	@Test
  public void getProductList() {
		 // ✅ Get token inside test (safe)
       //String token=APIUtils.getToken();

        // ✅ Extract response properly
        Response res =
                given()
                        .spec(RequestSpecUtils.getProducts()).log().headers().log().body().log().uri()
                        
                .when()
                        .get("/products")
                .then().spec(ResponseSpecUtils.getResSpec()).log().status()
                        .statusCode(200)
                        .extract()
                        .response();
  }
	
	@Test
	  public void getTokenTest() {
			 // ✅ Get token inside test (safe)
	       

	        // ✅ Extract response properly
	        String token =
	        		given().spec(RequestSpecUtils.loginSpec())
	        		.when().post("/auth/login")
	        		.then().statusCode(201)
	        			   .extract()
	        			   .response().jsonPath().getString("token");
	        Assert.assertNotNull(token);
	  }
}
