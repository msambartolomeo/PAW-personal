package ar.edu.itba.paw.model;

import javax.persistence.*;

@Entity
@Table(name = "users_inheritance")
public class UserInheritance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_inheritance_userid_seq")
    @SequenceGenerator(allocationSize = 1, name = "users_inheritance_userid_seq", sequenceName = "users_inheritance_userid_seq")
    private Long userId;
    @Column(length = 100, nullable = false, unique = true)
    private String username;
    @Column(length = 100, nullable = false)
    private String password;

    UserInheritance() {}

    public UserInheritance(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Deprecated
    public UserInheritance(long id, String username, String password) {
        this.userId = id;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getUserId() {
        return userId;
    }
}
