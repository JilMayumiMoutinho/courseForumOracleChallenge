package br.com.oracle.courseForum.domain.user;

import br.com.oracle.courseForum.infra.security.Encrypt;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean admin;

    public User(UserCreationDTO userReceived) {
        this.name = userReceived.name();
        this.email = userReceived.email();
        this.password = Encrypt.encrypt(userReceived.password());
        this.admin = userReceived.admin();
    }
}
