package ru.profiteam.watershop.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.service.TokenService;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hibernate.type.descriptor.java.JdbcDateTypeDescriptor.DATE_FORMAT;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final String SIGNING_KEY = "342";

    @Override
        public String buildToken(Long userId) {
            List<GrantedAuthority> auths = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            auths.add(new SimpleGrantedAuthority(String.valueOf(userId)));

            Date tokenLife = Date.from(Instant.now().plusSeconds(315360000));
            return Jwts.builder()
                    .claim("authorities", auths.stream()
                            .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .setIssuedAt(Date.from(Instant.now()))
                    .setExpiration(tokenLife)
                    .signWith(SignatureAlgorithm.HS256, SIGNING_KEY.getBytes())
                    .compact();
        }

    @Override
        public Long parseJwt(String token) {
            Objects.requireNonNull(token);
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(SIGNING_KEY.getBytes())
                        .parseClaimsJws(token)
                        .getBody();

                List<String> authorities = claims.get("authorities", List.class);
                return authorities.stream().findFirst().map(Long::parseLong).orElse(0L);
            } catch (Exception ex) {
                return null;
            }
        }
}
