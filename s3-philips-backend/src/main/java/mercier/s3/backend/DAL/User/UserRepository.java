package mercier.s3.backend.DAL.User;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public User findByName(String name)
    {
        return find("Name", name).firstResult();
    };
    public User findById(String id) {return find("Id", id).firstResult();};

    public void SaveUser(User user){
        persist(user);
    }
}
