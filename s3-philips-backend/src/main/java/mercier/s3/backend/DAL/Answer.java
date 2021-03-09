package mercier.s3.backend.DAL;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answer extends PanacheEntityBase {

    @Id
    private String id;
    private String Answer;
    private boolean IsCorrect;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isCorrect() {
        return IsCorrect;
    }

    public void setCorrect(boolean correct) {
        IsCorrect = correct;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
