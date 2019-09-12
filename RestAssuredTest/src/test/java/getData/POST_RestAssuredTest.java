package getData;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_RestAssuredTest {
	
	@Test
	public void test() {
		RequestSpecification request=RestAssured.given();
		
		request.headers("Content-Type", "application/json");
		
		JSONObject json=new JSONObject();
		
		json.put("name", "morpheus");
		json.put("job", "zion resident");
		
		request.body(json.toJSONString());
		
		Response resp=request.post("https://reqres.in/api/users/2");
		
		int code=resp.getStatusCode();
		
		Assert.assertEquals(code,201);
	}

}
