//package com.Aditya.ProfileManagement.Config;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
//import java.security.Key;
//import java.util.Date;
//
//public class JwtUtils {
//
//    private static final String SECRET_KEY = "adityataitkar121120"; // Replace with your own secret key
//
//    public static String generateToken(String username, String role, long expirationTime) {
//        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
//
//        return Jwts.builder()
//                .setSubject(username)
//                .claim("role", role)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//    }
//}
