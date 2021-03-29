package mercier.s3.backend.Logic;

import com.google.gson.JsonObject;
import mercier.s3.backend.DAL.Lesson;
import mercier.s3.backend.DAL.Question;
import mercier.s3.backend.DAL.QuestionRepository;
import mercier.s3.backend.Models.Questions.AddQuestion;
import mercier.s3.backend.Models.Questions.EditQuestion;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class QuestionManager {
    @Inject LessonManager lessonManager;
    @Inject QuestionRepository questionRepository;

    public Question CreateQuestion(AddQuestion addQuestion){

        Question question = new Question();
        question.setId(UUID.randomUUID().toString());
        question.setQuestion(addQuestion.getQuestion());
        question.setType(addQuestion.getType());
        question.persist();
        lessonManager.AddQuestion(addQuestion.getLessonId(), question);
        return question;
    }

    public Question EditQuestion(EditQuestion editQuestion){
        Question question = questionRepository.findById(editQuestion.getId());
        question.setQuestion(editQuestion.getQuestion());
        question.setType(editQuestion.getType());
        question.Save();
        return question;
    }

    public boolean DeleteQuestion(JsonObject obj) {
        Lesson lesson = lessonManager.GetLesson(obj.get("LessonID").getAsString());
        Question question = questionRepository.findById(obj.get("QuestionID").getAsString());
        lesson.getQuestions().remove(question);
        question.delete();
        return false;
    }
}
