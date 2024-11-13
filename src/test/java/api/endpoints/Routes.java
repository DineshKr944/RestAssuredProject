package api.endpoints;

public class Routes {

	public static String base_url="http://localhost:5000/api";
	
	//user module
	
	public static String post_url=base_url+"/user/register";
	public static String get_url=base_url+"/user/{id}";
	public static String update_url=base_url+"/user/{id}";
	public static String delete_url=base_url+"/user/{id}";
	
	//login module
	public static String login_user=base_url+"/user/login";
	
	//store module
}
