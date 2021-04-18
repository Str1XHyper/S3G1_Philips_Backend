package mercier.s3.backend.Models.Answer;

import java.util.List;

public class AddAnswer {
    private List<AnswerObject> answers;
    private String questionID;

    public List<AnswerObject> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerObject> answers) {
        this.answers = answers;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }
}
