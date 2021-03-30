package mercier.s3.backend.Logic;

import mercier.s3.backend.DAL.Lesson.Lesson;
import mercier.s3.backend.DAL.Lesson.LessonRepository;
import mercier.s3.backend.DAL.Question.Question;
import mercier.s3.backend.DAL.User.User;
import mercier.s3.backend.DAL.User.UserRepository;
import mercier.s3.backend.Models.Lessons.AddLesson;
import mercier.s3.backend.Models.Lessons.DeleteLesson;
import mercier.s3.backend.Models.Lessons.EditLesson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class LessonManager {

    @Inject
    LessonRepository lessonRepository;
    @Inject
    UserRepository userRepository;

    public Lesson CreateLesson(AddLesson addLesson){
        Lesson lesson = new Lesson();
        lesson.setId(UUID.randomUUID().toString());
        lesson.setName(addLesson.getName());
        User user = userRepository.findById(addLesson.getOwnerID());
        lesson.setOwner(user);
        lessonRepository.persist(lesson);
        return lesson;
    }

    public List<Lesson> GetLessons()
    {
        return lessonRepository.findAll().list();
    }

    public Lesson EditLessons(EditLesson editLesson){
        Lesson lesson = lessonRepository.findById(editLesson.getiD());
        lesson.setName(editLesson.getName());
        lesson.Save();
        return lesson;
    }

    public boolean DeleteLesson(DeleteLesson lesson){
        lessonRepository.DeleteLesson(lesson.getiD());
        return true;
    }

    public boolean AddQuestion(String lessonId, Question question) {
        Lesson lesson = lessonRepository.findById(lessonId);
        if (lesson == null) {
            return false;
        }
        lesson.addQuestion(question);
        return true;
    }

    public Lesson GetLesson(String ID) {
        return lessonRepository.findById(ID);
    }
    public Lesson GetLessonByName(String Name) {
        return lessonRepository.findByName(Name);
    }
}
