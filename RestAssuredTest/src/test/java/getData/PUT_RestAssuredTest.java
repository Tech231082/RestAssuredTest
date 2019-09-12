package getData;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUT_RestAssuredTest {
	
	@Test
	public void test() {
		RequestSpecification request=RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject json=new JSONObject();
		
		json.put("id", 7);
		json.put("email","michael.lawson@reqres.in" );
		json.put("first_name", "Sanom");
		json.put("last_name", "Wattson");
		json.put("avatar","https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg");
		
		request.body(json.toJSONString());
		
		Response resp=request.put("https://reqres.in/api/users/2");
		
		int code=resp.getStatusCode();
		
		Assert.assertEquals(code, 200);
		
		
	}

}
