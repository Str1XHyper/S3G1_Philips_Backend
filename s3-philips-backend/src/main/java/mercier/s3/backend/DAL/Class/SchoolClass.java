package mercier.s3.backend.DAL.Class;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import mercier.s3.backend.DAL.User.User;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class SchoolClass extends PanacheEntityBase {

    @Id
    private String id;

    @ManyToMany
    @JoinTable(
            name = "SchoolClass_User"
    )
    @JsonbTransient
    private List<User> users;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "id='" + id + '\'' +
                ", users=" + users +
                ", name='" + name + '\'' +
                '}';
    }
}
