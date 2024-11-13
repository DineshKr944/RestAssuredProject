package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestClass {

	static User user;

	@BeforeClass
	public static Response CreateUser() {
		user=new User();
		user.setFirst_name("Kamlesh");
		user.setLast_name("Kumar");
		user.setDob("1996-02-03");
		user.setEmail("Kamlesh@gmail.com");
		user.setMobile("9987654321");
		user.setPassword("Kamlesh123");

		Response res=given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(user)
				.when()
				.post("http://localhost:5000/api/user/register");
		return res;
	}
	@Test
	public static void userCreate() {
		//given
	}
}
