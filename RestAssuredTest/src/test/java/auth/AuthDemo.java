package auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class AuthDemo {
@Test
public void test() {
	Response resp=RestAssured.given().auth().oauth("SIaaiaaeVH48XX32kVXLD6myI", 
			"c8wm4VkX9lnXIX5tCpMXAPKGtSNdYmyTO6Ltbuyce08sy7NETk", 
			"1172612225002946561-rf3hFgYd8sHZVY0n2uWFGxx5Ac0S1y", 
			"zjcxn8WoZwfE5FkiiCZnQsUNqIIWkvxFElhsoRb8ah1CV")
	.post("https://api.twitter.com/1.1/statuses/update.json?status=This is a tweet through API");
	
	int code=resp.getStatusCode();
	
	System.out.println(code);
	
	Assert.assertEquals(200, code);
	
	System.out.println(resp.getBody().jsonPath().prettify());
	
	JsonPath path=resp.jsonPath();
	
	String tweetID=path.get("id_str");
	
	System.out.println(tweetID);

}
}
