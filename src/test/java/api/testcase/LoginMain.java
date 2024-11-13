package api.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.endpoints.Routes;
import api.payload.Login;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginMain {

	@Test(priority = 3)
	public static void testLoginUser() throws JsonProcessingException {
	    Login l = new Login();
	    l.setUsername("Kamlesh@gmail.com");
	    l.setPassword("Kamlesh123");

	    // Print JSON payload for debugging
	    String jsonPayload = new ObjectMapper().writeValueAsString(l);
	    System.out.println("Payload: " + jsonPayload);

	    // Send request with appropriate content type
	    Response response = given()
	        .contentType(ContentType.JSON)
	        .body(l)
	        .when()
	        .post(Routes.login_user);  // replace with your endpoint

	    // Log response
	    response.then().log().all();

	    // Assert status code
	    Assert.assertEquals(response.statusCode(), 200, "Expected status code 200, but found " + response.statusCode());
	}

}
