package mercier.s3.backend.Logic;

import com.google.gson.JsonObject;
import mercier.s3.backend.DAL.Lesson;
import mercier.s3.backend.DAL.Question;
import mercier.s3.backend.DAL.QuestionRepository;
import mercier.s3.backend.DAL.QuestionTypes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;
import java.util.logging.Logger;

@ApplicationScoped
public class QuestionManager {
    @Inject LessonManager lessonManager;
    @Inject QuestionRepository questionRepository;
    private static Logger logger = Logger.getLogger(QuestionManager.class.getName());

    public boolean CreateQuestion(JsonObject obj){
        if(!obj.has("LessonID") || !obj.has("Question") || !obj.has("Type")){
            logger.warning("LessonID, Question and Type are required fields");
            return false;
        }

        Question question = new Question();
        question.setID(UUID.randomUUID().toString());
        question.setQuestion(obj.get("Question").getAsString());
        question.setType(QuestionTypes.valueOf(obj.get("Type").getAsString()));
        question.persist();
        lessonManager.AddQuestion(obj.get("LessonID").getAsString(),question);
        return true;
    }

    public boolean EditQuestion(JsonObject obj){
        if(!obj.has("QuestionID") || !obj.has("Question") || !obj.has("Type")){
            logger.warning("QuestionID, Question and Type are required fields");
            return false;
        }
        Question question = questionRepository.findById(obj.get("QuestionID").getAsString());
        question.setQuestion(obj.get("Question").getAsString());
        question.setType(QuestionTypes.valueOf(obj.get("Type").getAsString()));
        question.persist();
        return true;
    }

    public boolean DeleteQuestion(JsonObject obj) {
        Lesson lesson = lessonManager.GetLesson(obj.get("LessonID").getAsString());
        Question question = questionRepository.findById(obj.get("QuestionID").getAsString());
        lesson.getQuestions().remove(question);
        question.delete();
        return false;
    }
}
