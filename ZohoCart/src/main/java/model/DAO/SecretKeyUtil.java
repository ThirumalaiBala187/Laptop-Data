package model.DAO;

import java.security.Key;

import io.jsonwebtoken.security.Keys;

public class SecretKeyUtil {
	private static final String Secret="0123456789abcdef0123456789abcdef";
	private static final Key secretKey=Keys.hmacShaKeyFor(Secret.getBytes());
	public static Key getSecretKey() {
		return secretKey;
	}
	
}
