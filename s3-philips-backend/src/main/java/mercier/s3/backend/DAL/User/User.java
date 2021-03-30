package mercier.s3.backend.DAL.User;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends PanacheEntityBase {

    @Id
    private String id;
    private String firstname;
    private String lastname;

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
}
