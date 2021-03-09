package mercier.s3.backend.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mercier.s3.backend.DAL.Lesson;
import mercier.s3.backend.Logic.LessonManager;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/Lesson")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class LessonController {
    @Inject LessonManager lessonManager;
    private static Logger logger = Logger.getLogger(LessonController.class.getName());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Add")
    public String AddLesson(String data){

        JsonObject obj = new Gson().fromJson(data, JsonObject.class);
        lessonManager.CreateLesson(obj);

        return new Gson().toJson(obj);
    }

    @GET
    @Path("/Get")
    public String GetLessons()
    {
        List<Lesson> lessons = lessonManager.GetLessons();
        return new Gson().toJson(lessons);
    }

    @POST
    @Path("/Edit")
    public String EditLesson(String data){
        JsonObject obj = new Gson().fromJson(data, JsonObject.class);
        boolean response = lessonManager.EditLessons(obj);
        return String.valueOf(response);
    }

    @POST
    @Path("/Delete")
    public String DeleteLesson(String data){
        JsonObject obj = new Gson().fromJson(data, JsonObject.class);
        boolean response = lessonManager.DeleteLesson(obj);
        return String.valueOf(response);
    }
}
