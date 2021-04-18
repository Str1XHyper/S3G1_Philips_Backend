package mercier.s3.backend.Logic;

import com.google.gson.JsonObject;
import mercier.s3.backend.DAL.Answer.Answer;
import mercier.s3.backend.DAL.Answer.AnswerRepository;
import mercier.s3.backend.DAL.Lesson.Lesson;
import mercier.s3.backend.DAL.Question.Question;
import mercier.s3.backend.DAL.Question.QuestionRepository;
import mercier.s3.backend.Models.Answer.AddAnswer;
import mercier.s3.backend.Models.Answer.AnswerObject;
import mercier.s3.backend.Models.Questions.AddQuestion;
import mercier.s3.backend.Models.Questions.DeleteQuestion;
import mercier.s3.backend.Models.Questions.EditQuestion;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.*;

@ApplicationScoped
public class QuestionManager {
    @Inject LessonManager lessonManager;
    @Inject
    QuestionRepository questionRepository;
    @Inject
    AnswerRepository answerRepository;

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

    public boolean DeleteQuestion(DeleteQuestion deleteQuestion) {
        Lesson lesson = lessonManager.GetLesson(deleteQuestion.getLessonID());

        Question question = questionRepository.findById(deleteQuestion.getQuestionID());
        lesson.getQuestions().remove(question);
        question.delete();
        return true;
    }

    public boolean SetAnswers(AddAnswer addAnswer){
        System.out.println(addAnswer.toString());
        Question question = questionRepository.findById(addAnswer.getQuestionID());
        List<Answer> answers = new ArrayList<>();

        for(AnswerObject answerObject: addAnswer.getAnswers()){
            Answer answer = answerRepository.findById(answerObject.getId());
            if(answer != null){
                answer.setAnswer(answerObject.getAnswer());
                answer.setCorrect(answerObject.getCorrect());
            } else {
                answer = new Answer();
                answer.setAnswer(answerObject.getAnswer());
                answer.setCorrect(answerObject.getCorrect());
                answer.setId(UUID.randomUUID().toString());
            }
            answerRepository.persist(answer);
            answers.add(answer);
        }
        question.setAnswers(answers);
        return true;
    }

    public List<Answer> getAnswers(String questionID) {
        Question question = questionRepository.findById(questionID);
        return question.getAnswers();
    }
}
