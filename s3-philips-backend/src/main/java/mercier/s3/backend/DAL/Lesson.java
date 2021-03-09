package mercier.s3.backend.DAL;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lesson extends PanacheEntityBase {

    @Id
    private String Id;
    private String Name;

    @OneToOne
    private User Owner;

    @OneToMany
    private List<Question> questions;


    public String getId() {
        return this.Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }

    public User getOwner_of_Lesson() {
        return this.Owner;
    }
    public void setOwner_of_Lesson(User Owner) {
        this.Owner = Owner;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean Save(){
        persist();
        return true;
    }
}
