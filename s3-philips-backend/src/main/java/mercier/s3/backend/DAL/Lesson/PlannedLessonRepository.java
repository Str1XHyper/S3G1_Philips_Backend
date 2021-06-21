package mercier.s3.backend.DAL.Lesson;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import mercier.s3.backend.DAL.Class.SchoolClass;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PlannedLessonRepository implements PanacheRepository<PlannedLesson> {
    public Lesson GetLessonFromPlanned(String PlannedLessonID){
        return find("id", PlannedLessonID).firstResult().getLesson();
    }

    public List<PlannedLesson> getPlannedByClasses(List<SchoolClass> classes) {
        return list("schoolClass_id in ?1", classes);
    }
}
