package com.djedra.shop.jwt.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class JWTFilter extends BasicAuthenticationFilter {

//	klucz do zaszyfrowania
//	rola musi mieć przedrostek "ROLE_". Niektóre klasy tego nie wymagają bno same przedrostek dodają
	private final static String key = "aaa";

	public JWTFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);

	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader("Authorization");
		UsernamePasswordAuthenticationToken authResult = null;
		try {
			authResult = getAuthenticationByToken(header);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		przechowuje info na temat zalogowanego uzytkownika
		SecurityContextHolder.getContext().setAuthentication(authResult);
//		trzeba pózniej przekazać żądanie dalej. Puścić program
		chain.doFilter(request, response);
	}

//HEADER:ALGORITHM & TOKEN TYPE
//
//{
//  "alg": "HS256",
//  "typ": "JWT"
//}
//PAYLOAD:DATA
//
//	{
//		  "sub": "1234567890",
//		  "name": "Diego",
//		  "role": "ROLE_admin",
//		  "iat": 1516239022
//		}
//VERIFY SIGNATURE
//
//HMACSHA256(
//  base64UrlEncode(header) + "." +
//  base64UrlEncode(payload),
//  
//aaa
//

	private UsernamePasswordAuthenticationToken getAuthenticationByToken(String header) throws Exception {
		if (Objects.isNull(header) || header.length() == 0) {
			throw new Exception("Authorization Header empty or null!");
		}
//		Bearer - to nagłówek dodawany z posmana. Trzeba się go pozyć ponieważ jest zbędny
		Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey(key.getBytes())
				.parseClaimsJws(header.replace("Bearer ", ""));

		Object nameObj = parseClaimsJws.getBody().get("name");
		if (Objects.isNull(nameObj) || !(nameObj instanceof String)) {
			throw new Exception("User name empty or null!");
		}
		String name = nameObj.toString();
		Object roleObj = parseClaimsJws.getBody().get("role");
		if (Objects.isNull(roleObj) || !(roleObj instanceof String)) {
			throw new Exception("Role empty or null!");
		}
		String role = roleObj.toString();

//		login password role
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				name, null, Collections.singleton(new SimpleGrantedAuthority(role)));
		return usernamePasswordAuthenticationToken;
	}
}
