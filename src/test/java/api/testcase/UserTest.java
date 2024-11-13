package api.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.Login;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	static String custID;
	static User UserPayload;
	static String username;
	static String password;
	static Login l;
	@BeforeClass
	public static void generateTestData() {
		UserPayload=new User();

		UserPayload.setFirst_name("Kamlesh");
		UserPayload.setLast_name("Kumar");
		UserPayload.setDob("1996-02-03");
		UserPayload.setEmail("Kamlesh@gmail.com");
		UserPayload.setMobile("9987654321");
		UserPayload.setPassword("Kamlesh123");
	}
	@Test(priority = 1)
	public static void testCreateUser() {
		Response response = UserEndPoints.createUser(UserPayload);

		//Log Response
		response.then().log().all();

		custID = response.jsonPath().getString("data._id");
		System.out.println("Customer ID: " + custID);
	}
	@Test(priority = 2)
	public static void testGetUser() {
		Response respons = UserEndPoints.getUser(custID);

		//Log Response
		respons.then().log().all();

		//Validate
		Assert.assertEquals(respons.statusCode(), 200);
	}
		
	@Test(priority = 3)
	public static void testDeleteUser() {
		Response respons = UserEndPoints.deleteUser(custID);

		//Log Response
		respons.then().log().all();

		//Validate
		Assert.assertEquals(respons.statusCode(), 200);
	}
}
