package mercier.s3.backend.Logic;

import com.google.gson.JsonObject;
import mercier.s3.backend.Controller.LessonController;
import mercier.s3.backend.DAL.Lesson;
import mercier.s3.backend.DAL.LessonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@ApplicationScoped
public class LessonManager {
    private static Logger logger = Logger.getLogger(LessonManager.class.getName());
    @Inject LessonRepository lessonRepository;
    public boolean CreateLesson(JsonObject obj){
        if(!obj.has("Name")){
            return false;
        }
        Lesson lesson = new Lesson();
        lesson.setId(UUID.randomUUID().toString());
        lesson.setName(obj.get("Name").getAsString());
        lessonRepository.persist(lesson);
        return true;
    }

    public List<Lesson> GetLessons()
    {
        return lessonRepository.findAll().list();
    }

    public boolean EditLessons(JsonObject obj){
        logger.info(obj.toString());
        if(!obj.has("Id") && !obj.has("Name")){
            logger.warning("Id and Name fields are required");
            return false;
        }
        Lesson lesson = lessonRepository.findById(obj.get("Id").getAsString());
        if(lesson == null){
            logger.warning("Lesson is null");
            return false;
        }

        lesson.setName(obj.get("Name").getAsString());
        lesson.Save();
        return true;
    }

    public boolean DeleteLesson(JsonObject obj){
        if(!obj.has("Id")){
            logger.warning("Id field is required");
            return false;
        }
        lessonRepository.DeleteLesson(obj.get("Id").getAsString());
        return true;
    }
}
