package mercier.s3.backend.Controller;

import mercier.s3.backend.DAL.Lesson.Lesson;
import mercier.s3.backend.DAL.Lesson.PlannedLesson;
import mercier.s3.backend.Logic.LessonManager;
import mercier.s3.backend.Models.Lessons.AddLesson;
import mercier.s3.backend.Models.Lessons.DeleteLesson;
import mercier.s3.backend.Models.Lessons.EditLesson;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Lesson")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class LessonController {
    @Inject LessonManager lessonManager;

    @POST
    @Path("/Add")
    public Lesson AddLesson(AddLesson addLesson){
        return lessonManager.CreateLesson(addLesson);
    }

    @GET
    public List<Lesson> GetLessons(){
        return lessonManager.GetLessons();
    }
    @GET
    @Path("/GetByOwner/{OwnerID}")
    public List<Lesson> GetLessons(@PathParam("OwnerID") String ownerID){
        return lessonManager.GetLessonsByOwner(ownerID);
    }

    @GET
    @Path("/GetByName/{Name}")
    public Lesson GetLesson(@PathParam("Name") String name){
        return lessonManager.GetLessonByName(name);
    }

    @PUT
    @Path("/Edit")
    public Lesson EditLesson(EditLesson editLesson){
        return lessonManager.EditLessons(editLesson);
    }

    @DELETE 
    @Path("/Delete")
    public String DeleteLesson(DeleteLesson deleteLesson){
        return String.valueOf(lessonManager.DeleteLesson(deleteLesson));
    }

    @GET
    @Path("/GetPlanned/{UserID}")
    public List<PlannedLesson> GetPlannedLessons(@PathParam("UserID") String userID){
        return lessonManager.GetPlanned(userID);
    }
}
