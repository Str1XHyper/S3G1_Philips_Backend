package mercier.s3.backend.Logic;

import mercier.s3.backend.DAL.Class.ClassRepository;
import mercier.s3.backend.DAL.Class.SchoolClass;
import mercier.s3.backend.DAL.User.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ClassManager {
    @Inject
    ClassRepository classRepository;

    public List<SchoolClass> GetAllClasses(){
        return classRepository.listAll();
    }

    public List<User> GetStudents(String classID) {
        SchoolClass schoolClass = classRepository.findById(classID);
        if(schoolClass != null){
            return schoolClass.getUsers();
        } else {
            return null;
        }
    }
}
