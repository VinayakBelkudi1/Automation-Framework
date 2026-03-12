package auth;

public class TokenManager {
	public static String token;
	
	public static String getToken() {
		if(token==null) {
			token =generateToken();
		}
		return token;
	}
	
	public static String generateToken() {
		
		return "Bearer Dummy Token";
		
	}

}
