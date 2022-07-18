package lt.codeacademy.anestheticChart.jpa.entity.user;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "Users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String zipCode;
    private String phoneNumber;

    @ManyToMany
    private Set<Authority> authorities;
}
