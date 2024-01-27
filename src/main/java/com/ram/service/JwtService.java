package com.ram.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtService {

    private static final CharSequence SECRET = null;

    public String generateToken(String userName) {
	Map<String, Object> claims = new HashMap();
	return Jwts.builder()
		.setClaims(claims)
		.setSubject(userName)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
		.signWith(getSignKey(),SignatureAlgorithm.HS256).compact();
    }
    
    private Key getSignKey() {
	byte[] keyBytes = Decoders.BASE64.decode(SECRET);
	return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public String extractUserName(String token) {
	return extractClaim(token,Claims::getSubject);
    }
    
    public Date expirationTime(String token) {
	return extractClaim(token, Claims::getExpiration);
    }
    
    private <T>T extractClaim(String token, Function<Claims, T>claimResolver) {
	final Claims claims = extractAllClaims(token);
	return claimResolver.apply(claims);
    }
    
    public Boolean isTokenExpired(String token) {
	return expirationTime(token).before(new Date());
    }
    
    public Boolean validateToken(String token,UserDetails userDetail) {
	final String userName = extractUserName(token);
	return (userName.equals(userDetail.getUsername()) && isTokenExpired(token));
    }
    
    private Claims extractAllClaims(String token) {
	return Jwts.parser()
			.setSigningKey(getSignKey())
			.build()
			.parseClaimsJws(token)
			.getBody();
    }
}
