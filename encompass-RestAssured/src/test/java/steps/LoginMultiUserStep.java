package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


import org.testng.Assert;

import pojo.LoginMultiUserPojo;

public class LoginMultiUserStep {
	LoginMultiUserPojo payload;
	 Response res;
	@Given("user prepare login payload with {string} and {string}")
	public void user_prepare_login_payload_with_and(String uname, String pass) {
	    
	 payload=new LoginMultiUserPojo(uname,pass);
	   
	}
	@When("user send POST request to {string}")
	public void user_send_post_request_to(String url) {
	   res = given()
			   .contentType("application/json")
			   .body(payload)
			   .when()
			   .post(url);
	   res.prettyPrint();
	}
	
	@Then("response status code should be {int}")
	public void response_status_code_should_be(Integer statusCode) {
		
		int StatusCodeActual=res.getStatusCode();
		Assert.assertEquals(StatusCodeActual, statusCode);
	}

}
