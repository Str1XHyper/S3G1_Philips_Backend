package mercier.s3.backend.DAL;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import mercier.s3.backend.Controller.LessonController;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ApplicationScoped
public class LessonRepository implements PanacheRepository<Lesson> {

    public Lesson findByName(String name)
    {
        return find("Name", name).firstResult();
    };
    public Lesson findById(String Id){
        return find("Id", Id).firstResult();
    }

    public void DeleteLesson(String Id){
        delete("Id", Id);
    }
}
