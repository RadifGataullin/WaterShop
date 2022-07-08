package ru.profiteam.watershop.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateUserDto;
import ru.profiteam.watershop.dto.request.RegistrationDto;
import ru.profiteam.watershop.dto.response.SessionDto;
import ru.profiteam.watershop.dto.response.UserDto;
import ru.profiteam.watershop.repository.ApproveCodeRepository;
import ru.profiteam.watershop.repository.UserRepository;
import ru.profiteam.watershop.service.UserService;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static org.hibernate.type.descriptor.java.JdbcDateTypeDescriptor.DATE_FORMAT;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserBuilder userBuilder;
    ApproveCodeRepository approveCodeRepository;

    @Override
    public SessionDto registration(String login, String password) {
        return null;
    }

    @Override
    public UserDto registration(String fullName, String password, String email, int phoneNumber) {
        return null;
    }

    @Override
    public boolean verify(long userId, long code) {
        return false;
    }

    @Override
    public Long createActivationCode(Long userId) {
        return null;
    }

    @Override
    public void create(RegistrationDto request) {
        if (request.getPassword().length() < 6) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        var approveLoginOpt = approveCodeRepository
                .findFirstByNumberAndIsActivatedTrue(request.getLogin());
        if (approveLoginOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
        var userLoginOpt = userRepository.findFirstByLogin(request.getLogin());
        if (userLoginOpt.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        var entityUser = userBuilder.regBuild(request);
        userRepository.save(entityUser);
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public void update(Long id, CreateUserDto request) {

    }

    @Override
    public void deleteById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        userRepository.deleteById(id);
    }


    public static void main(String[] args) {

    }
    private final String SIGNING_KEY = "weuksfjdhjkfsdd";

    public String build(Long userId) {
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
