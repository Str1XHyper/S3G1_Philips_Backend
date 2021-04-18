package mercier.s3.backend.DAL.Lesson;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import mercier.s3.backend.DAL.Class.SchoolClass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class PlannedLesson extends PanacheEntityBase {
    @Id
    private String id;

    @ManyToOne
    private SchoolClass schoolClass;
    @ManyToOne
    private Lesson lesson;
    private LocalDateTime plannedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public LocalDateTime getPlannedTime() {
        return plannedTime;
    }

    public void setPlannedTime(LocalDateTime plannedTime) {
        this.plannedTime = plannedTime;
    }
}
