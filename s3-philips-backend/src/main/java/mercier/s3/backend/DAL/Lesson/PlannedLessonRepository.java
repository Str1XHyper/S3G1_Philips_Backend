package mercier.s3.backend.DAL.Lesson;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlannedLessonRepository implements PanacheRepository<PlannedLesson> {
    public Lesson GetLessonFromPlanned(String PlannedLessonID){
        return find("id", PlannedLessonID).firstResult().getLesson();
    }
}
