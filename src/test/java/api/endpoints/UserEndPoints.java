package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.Login;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User Payload) {

		Response res=given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(Payload)
				.when()
				.post(Routes.post_url);
		return res;

	}
	public static Response getUser(String custID) {

		Response res=given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				 .pathParam("id", custID)
				.when()
				.get(Routes.get_url);
		return res;

	}
	public static Response updateUser(String custID,User payload) {

		Response res=given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				 .pathParam("id", custID)
				 .body(payload)
				.when()
				.patch(Routes.update_url);
		return res;
	}
	public static Response deleteUser(String custID) {

		Response res=given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				 .pathParam("id", custID)
				.when()
				.delete(Routes.delete_url);
		return res;

	}
	public static Response loginUser(Login payload) {

		Response res=given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload.toString())
				.when()
				.post(Routes.login_user);
		return res;

	}
}
