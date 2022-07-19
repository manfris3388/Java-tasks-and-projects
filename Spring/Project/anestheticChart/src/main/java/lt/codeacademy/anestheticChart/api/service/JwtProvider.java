package lt.codeacademy.anestheticChart.api.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lt.codeacademy.anestheticChart.mvc.user.dto.UserRoleDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

  private static final Date NOW = new Date();

  @Value("#{${security.jwt.validity-time} * 60 * 1000}")
  private long tokenValidityInMillis;

  @Value("${security.jwt.secret-key}")
  private byte[] secretKey;

  public String getToken(UserRoleDto principal) {
    return Jwts.builder()
        .setHeaderParam("typ", "JWT")
        .setIssuer("anestheticChart-api")
        .setAudience("anestheticChart-ui")
        .setSubject(principal.getUsername())
        .setIssuedAt(NOW)
        .setExpiration(new Date(NOW.getTime() + tokenValidityInMillis))
        .claim(
            "roles",
            principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet()))
        .signWith(Keys.hmacShaKeyFor(secretKey), SignatureAlgorithm.HS512)
        .compact();
  }

  public Authentication parseToken(String token) {
    // validate token by secret key and get JWT payload as Claims
    Claims parsedJwtBody = Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .getBody();


    String username = parsedJwtBody.getSubject();
    List<GrantedAuthority> authorities = ((List<String>) parsedJwtBody.get("roles")).stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

    return new UsernamePasswordAuthenticationToken(username, null, authorities);

  }
}
