package in.ineuron;

import in.ineuron.util.JwtUtilApp;
import io.jsonwebtoken.Claims;

public class App {
    public static void main(String[] args) {
        
    	String token = JwtUtilApp.generateToken("12345", "SpringSecurity", "Ineuron");
    	System.out.println("token:"+token);
    	
    	
    	
    	//get jwt payload/body info
    	
    	Claims claims = JwtUtilApp.getClaims("Ineuron", token);
    	System.out.println("Subject info :: " + claims.getSubject());
		System.out.println("Client id    :: " + claims.getId());
		System.out.println("Exprity date :: " + claims.getExpiration());
		System.out.println("IssuedDate time :: " + claims.getIssuedAt());
		
		System.out.println("IS Token valid      :: " + JwtUtilApp.isTokenValid("Ineuron", token));
		System.out.println("SubjectInfo         :: " + JwtUtilApp.getSubject("Ineuron", token));
		System.out.println("ExpiryDate and Time :: " + JwtUtilApp.getExpiryDate("Ineuron", token));


    }
}
