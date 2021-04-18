package mercier.s3.backend.DAL.Lesson;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import mercier.s3.backend.DAL.Question.Question;
import mercier.s3.backend.DAL.User.User;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class Lesson extends PanacheEntityBase {

    @Id
    private String id;
    private String name;

    @OneToOne
    private User owner;

    @ManyToMany
    @JsonbTransient
    private List<Question> questions;


    public String getId() {
        return this.id;
    }
    public void setId(String Id) {
        this.id = Id;
    }

    public User getOwner() {
        return this.owner;
    }
    public void setOwner(User Owner) {
        this.owner = Owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Save(){
        persist();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }
}
