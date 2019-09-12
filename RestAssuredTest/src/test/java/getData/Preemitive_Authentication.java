package getData;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Preemitive_Authentication {
	
	@Test
	public void test() {
		
		int code=RestAssured.given().auth().preemptive().basic("ToolsQA", "TestPassword").when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication").getStatusCode();
		System.out.println(code);
	}

}
