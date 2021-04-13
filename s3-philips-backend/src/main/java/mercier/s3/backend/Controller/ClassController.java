package mercier.s3.backend.Controller;

import mercier.s3.backend.DAL.Class.SchoolClass;
import mercier.s3.backend.DAL.User.User;
import mercier.s3.backend.Logic.ClassManager;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Class")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class ClassController {
    @Inject
    ClassManager classManager;

    @GET
    public List<SchoolClass> GetClasses(){
        return classManager.GetAllClasses();
    }

    @GET
    @Path("/Students/{ClassID}")
    public List<User> GetStudents(@PathParam("ClassID") String ClassID){
        return classManager.GetStudents(ClassID);
    }
}
