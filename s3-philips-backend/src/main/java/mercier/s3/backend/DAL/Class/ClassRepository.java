package mercier.s3.backend.DAL.Class;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ClassRepository implements PanacheRepository<SchoolClass> {
    public List<SchoolClass> listUserClasses(String userID) {
        return list("Users_id", userID);
    }

    public SchoolClass findById(String classID) {
        return find("id", classID).firstResult();
    }
}
