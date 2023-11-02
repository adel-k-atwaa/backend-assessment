package com.example.SystemDesign.Config;

import com.example.SystemDesign.Domain.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private final static String SECRIT_KEY="e87886b784462b74d987bdbf332eff6e8701f6bb6c0a401b8513351bd96a963f363adeb10dbd874af324ca473136bd9efa1fd50d346620d6e25c4bbbf6089584ee998850063f2a91363ca98c1353066dea6ff663163afcc4083ca9e03493800fe830138d181fe23bc33f66e1cdcd75418070200fb2100f4323ad909d8ae420aa";
    public String extractEmail(String token){
        return extractClaim(token,Claims::getSubject);
    }

    public Token generateToken(UserDetails userDetails){
        return Token.builder().token(generateToken(new HashMap<>(),userDetails)).build();
    }
    public String generateToken(Map<String,Object> extraClaims, UserDetails user){
        return Jwts.builder().setClaims(extraClaims).setSubject(user.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+1000*60*24)).signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        final String userEmail=extractEmail(token);
        return (userDetails.getUsername().equals(userEmail)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }

    private Key getSigningKey() {
        byte[] keyByets= Decoders.BASE64.decode(SECRIT_KEY);
        return Keys.hmacShaKeyFor(keyByets);
    }
}
