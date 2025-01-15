package br.com.oracle.courseForum.infra.security;

import br.com.oracle.courseForum.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceAPI {
    @Value("${api.security.token.secret}")
    private String secret;

    public String createToken(User user) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("courseForum")
                    .withSubject(user.getEmail())
                    .withClaim("id", user.getId()) //Pode ter ou não, insere informação do id do user como resposta
                    .withExpiresAt(expirationToken())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("ERRO AO GERAR TOKEN JWT", exception);
        }
    }

    private Instant expirationToken() {
        return LocalDateTime.now().plusHours(10).toInstant(ZoneOffset.of("-03:00"));
        //fuso do brasil é de -3h
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("courseForum")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
            throw new RuntimeException("Token JWT inválido ou expirado!" + exception.getMessage());
        }
    }
}
