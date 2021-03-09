package mercier.s3.backend.DAL;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Question extends PanacheEntityBase {

    @Id private String ID;
    private String Question;
    private QuestionTypes Type;
    @OneToMany
    private List<Answer> Answers;

    public QuestionTypes getType() {
        return Type;
    }

    public void setType(QuestionTypes type) {
        this.Type = type;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Answer> getAnswers() {
        return Answers;
    }

    public void setAnswers(List<Answer> answers) {
        Answers = answers;
    }
}
