package mercier.s3.backend.DAL.Question;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuestionRepository implements PanacheRepository<Question> {
    public void DeleteQuestion(String Id){
        delete("Id", Id);
    }
    public Question findById(String Id){
        return find("Id", Id).firstResult();
    }
}
