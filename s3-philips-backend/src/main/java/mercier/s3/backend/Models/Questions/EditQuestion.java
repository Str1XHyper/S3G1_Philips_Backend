package mercier.s3.backend.Models.Questions;

import mercier.s3.backend.DAL.QuestionTypes;

public class EditQuestion {
    private String id;
    private String question;
    private QuestionTypes type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
