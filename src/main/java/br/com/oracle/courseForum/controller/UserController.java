package br.com.oracle.courseForum.controller;

import br.com.oracle.courseForum.domain.user.*;
import br.com.oracle.courseForum.infra.security.TokenDetailDTO;
import br.com.oracle.courseForum.infra.security.TokenServiceAPI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenServiceAPI tokenService;

    @Autowired
    private UserAuthService userAuthService;

    @PostMapping
    @Transactional
    public ResponseEntity signUpUser(@RequestBody @Valid UserCreationDTO data, UriComponentsBuilder uriBuilder) {
        var encryptedPassword = userAuthService.encrytPassword(data.password());
        var user = new User(data, encryptedPassword);
        repository.save(user);
        var location = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(new UserDetailDAO(user.getName(), user.getId()));
    }

    @PostMapping("/login")
    public ResponseEntity signIn(@RequestBody @Valid UserAuthDTO loginData) {
        try {
            var token = new UsernamePasswordAuthenticationToken(loginData.email(), loginData.password());
            var auth = manager.authenticate(token);
            var tokenJWT = tokenService.createToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new TokenDetailDTO(tokenJWT));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

