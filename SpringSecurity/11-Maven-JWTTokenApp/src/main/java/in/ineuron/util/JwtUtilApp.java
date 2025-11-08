package in.ineuron.util;

import java.util.Date;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtilApp {

	// generate jwt tokens
	public static String generateToken(String id, String subject, String secretKey) {

		return Jwts.builder().setId(id).setSubject(subject).setIssuer("PWSKILLS")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1)))
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secretKey.getBytes())).compact();

	}
	// payload of jwt

	public static Claims getClaims(String secretKey, String token) {
		return Jwts.parser().setSigningKey(Base64.getEncoder().encode(secretKey.getBytes())).parseClaimsJws(token)
				.getBody();
	}

	public static boolean isTokenValid(String secretkey, String token) {
		Date tokenExpiryDate = getClaims(secretkey, token).getExpiration();
		Date date = new Date();
		boolean result = date.before(tokenExpiryDate);
		return result;
	}

	public static String getSubject(String secretekey, String token) {
		return getClaims(secretekey, token).getSubject();
	}

	public static Date getExpiryDate(String secretekey, String token) {
		return getClaims(secretekey, token).getExpiration();
	}

}
