package it.epicode.esercizi.cinema.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secrets;

	@Value("${jwt.expiration}")
	private Long expiration;

	public String generateJwtToken(Authentication auth) {
		UserDetImpl user = (UserDetImpl) auth.getPrincipal();
		Date now = new Date();
		Date exp = new Date((now).getTime() + this.expiration);
		user.setExpirationTime(exp);
		return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now).setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, secrets).compact();
	}

	public String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(this.secrets).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token) {
		try{
			Jwts.parser().setSigningKey(this.secrets).parseClaimsJws(token);
			return true;
		}
		catch(Exception e){
			log.error("token non valido"+e.getLocalizedMessage());
			return false;
	}

	}

}
