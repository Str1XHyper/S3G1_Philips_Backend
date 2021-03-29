package mercier.s3.backend.Models.Questions;

import mercier.s3.backend.DAL.QuestionTypes;

public class AddQuestion {

    private String lessonId;
    private String question;
    private QuestionTypes type;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionTypes getType() {
        return type;
    }

    public void setType(QuestionTypes type) {
        this.type = type;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }
}
