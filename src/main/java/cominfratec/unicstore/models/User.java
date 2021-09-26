package cominfratec.unicstore.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "user")

@ToString
@EqualsAndHashCode
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private Long id;

    @Column(nullable = false, length = 50)
    @Getter @Setter
    private String name;

    @Column (nullable = false, length = 11)
    @Getter @Setter
    private String cpf;

    @Column (nullable = false)
    @Getter @Setter
    private String email;

    @Column (nullable = false, length = 255)
    @Getter @Setter
    private String password;

    @Column (nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    private Date creationDate;

    @Column (nullable = false, length = 2)
    @Getter @Setter
    private String permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}
