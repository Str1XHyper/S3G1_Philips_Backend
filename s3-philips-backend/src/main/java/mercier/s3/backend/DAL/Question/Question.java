package mercier.s3.backend.DAL.Question;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import mercier.s3.backend.DAL.Answer.Answer;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Question extends PanacheEntityBase {

    @Id private String id;
    private String question;
    private QuestionTypes type;
    @OneToMany
    @JsonbTransient
    private List<Answer> answers;

    public QuestionTypes getType() {
        return type;
    }

    public void setType(QuestionTypes type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getId() {
        return id;
    }

    public void setId(String ID) {
        this.id = ID;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void Save() {
        persist();
    }
}
