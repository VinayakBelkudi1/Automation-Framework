package dummyjson;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class DummyJsonTest {
	
	@BeforeClass
	public void beforeClass() {
		RestAssured.baseURI="";
	}

}
