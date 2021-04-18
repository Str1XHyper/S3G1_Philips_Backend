package mercier.s3.backend.DAL.Answer;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AnswerRepository implements PanacheRepository<Answer> {

    public Answer findById(String Id){
        return find("Id", Id).firstResult();
    }
}
