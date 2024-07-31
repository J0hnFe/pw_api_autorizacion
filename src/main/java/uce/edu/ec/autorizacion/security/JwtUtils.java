package uce.edu.ec.autorizacion.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// Clase que genera el token JWT
@SuppressWarnings("deprecation")
@Component
public class JwtUtils {

	private String jwtSecret = "estasemillaesdemasiadalargaporseguridaddemiaplicacionweb12345612325814736912251789468894816486619848618948779516563";

	public String buildTokenJwt(String nombre, String jwtSemilla, Integer jwtExpiration) {
		return Jwts.builder().setSubject(nombre).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
				.signWith(SignatureAlgorithm.HS512, jwtSemilla).compact();
	}

	public String buildTokenJwt2(String nombre) {
		return Jwts.builder().setSubject(nombre).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 100000))
				.signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes()).compact();
	}
}
