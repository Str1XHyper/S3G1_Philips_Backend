package mercier.s3.backend.DAL.User;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import mercier.s3.backend.DAL.Class.SchoolClass;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class User extends PanacheEntityBase {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    @Column(unique = true, nullable = false)
    private String username;
    @Password
    @JsonbTransient
    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "SchoolClass_User"
    )
    @JsonbTransient
    private List<SchoolClass> classes;

    private UserRoles role;

    public String getId() {
        return id;
    }

    public void setId(String ID) {
        this.id = ID;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SchoolClass> getClasses() {
        return classes;
    }

    public void setClasses(List<SchoolClass> classes) {
        this.classes = classes;
    }
}
