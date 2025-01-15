package br.com.oracle.courseForum.controller;

import br.com.oracle.courseForum.domain.user.User;
import br.com.oracle.courseForum.domain.user.UserAuthDTO;
import br.com.oracle.courseForum.infra.security.TokenData;
import br.com.oracle.courseForum.infra.security.TokenServiceAPI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenServiceAPI tokenServiceAPI;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserAuthDTO data){
        try {
            var token = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var authentication = manager.authenticate(token);
            var tokenDTO = tokenServiceAPI.createToken((User) authentication.getPrincipal());
            return ResponseEntity.ok(new TokenData(tokenDTO));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
