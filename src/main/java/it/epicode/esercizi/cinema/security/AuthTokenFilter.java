package it.epicode.esercizi.cinema.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import it.epicode.esercizi.cinema.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {

	@Autowired
	JwtUtil jwt;

	@Autowired
	UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			try {
				String jwts=parseJwt(request);
					if(jwts!=null && this.jwt.validateToken(jwts)) {
					String username=this.jwt.getUsernameFromToken(jwts);
					UserDetails user=this.userService.loadUserByUsername(username);
					UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(
							user,null,user.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}catch(Exception e){
					log.error("Errore di autenticazione"+ e.getLocalizedMessage());
				}
			filterChain.doFilter(request, response);
			}
		
	

	private String parseJwt(HttpServletRequest request) {
		String auth = request.getHeader("Authorization");

		if (StringUtils.hasText(auth) && auth.startsWith("Bearer ")) {
			return auth.substring(7, auth.length());
		} else
			return null;
	}

}
